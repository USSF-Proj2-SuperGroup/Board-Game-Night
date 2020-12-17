import React, { Fragment, useEffect, useState } from "react";
import axios from 'axios';

const ListGames = () => {
    const [gameList, setGameList] = useState([]);
    const [gameNames, setGameNames] = useState([]);


    const getPageData = async () => {
        getGameNames();
        getGameList();
    }
    const getGameList = async () => {
        try {
            var id = 2;
            const response = await fetch(`http://localhost:8080/groupvote/${id}`);
            const jsonData = await response.json();
      
            setGameList(jsonData);
          } catch (err) {
            console.error(err.message);
          }
    };
    const getGameNames = async () => {
        try {
            const response = await fetch(`http://localhost:8080/games`);
            const jsonData = await response.json();
            setGameNames(jsonData);
        } catch (err) {
            console.error(err.message);
        }
    };

    useEffect(() => {
        // const abortController
        getPageData();
    
        
    }, []);

    //upvote a game function
   const upvoteGame = async id => {
    try {
        let headers = new Headers();
        //headers.append('Access-Control-Allow-Origin', 'http://localhost:8081/');
        //headers.append('Access-Control-Allow-Credentials', 'true');
        headers.append('Content-Type', 'application/json');
        let body = { id
          }
        const requestOptions = {
            method: 'PATCH',
            mode: 'cors',
            headers: headers,
            body: JSON.stringify(body)
        };
        await fetch(`http://localhost:8080/groupvote/upvote`, requestOptions)
          .then(response => response.json())
          .then(response => {
          if(response.status === "failed")
          alert(response.message)})
          
          getGameList();
    } catch (err) {
      console.error(err.message);
    }
  };
  //downvote a game function
  const downvoteGame = async id => {
    try {
        let headers = new Headers();
        //headers.append('Access-Control-Allow-Origin', 'http://localhost:8081/');
        //headers.append('Access-Control-Allow-Credentials', 'true');
        headers.append('Content-Type', 'application/json');
        let body = { id
          }
        const requestOptions = {
            method: 'PATCH',
            mode: 'cors',
            headers: headers,
            body: JSON.stringify(body)
        };
        await fetch(`http://localhost:8080/groupvote/downvote`, requestOptions)
          .then(response => response.json())
          .then(response => {
          if(response.status === "failed")
          alert(response.message)})

          getGameList();
    } catch (err) {
      console.error(err.message);
    }
  };

    return (
        <Fragment>
            {" "}
            <table className="table mt-5 text-center">
                <thead>
                    <tr>
                        <th>Game Name</th>
                        <th>Vote</th>
                        <th>Up Vote</th>
                        <th>Down Vote</th>
                    </tr>
                </thead>
                <tbody>
                    {gameList.map(each => (
                        <tr key = {each.id}>
                            {/* <td>{gameNames[each.gameID - 1].gameName}</td> */}
                            <td>{each.gameID}</td>
                            <td>{each.gameVotes}</td>
                            <td>
                                <button
                                    type="button" className="btn btn-success"
                                    onClick= {() => upvoteGame(each.id)}
                                    >
                                    I Want to Play
                                </button>
                            </td>
                            <td>
                                <button
                                    type="button" className="btn btn-danger"
                                    onClick= {() => downvoteGame(each.id)}
                                    >
                                    Hell no
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </Fragment>
    )

}
export default ListGames;
