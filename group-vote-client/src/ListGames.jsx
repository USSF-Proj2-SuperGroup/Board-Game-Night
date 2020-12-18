import React, { Fragment, useEffect, useState } from "react";

const ListGames = () => {
    const [gameList, setGameList] = useState([]);
    
    const getGameList = async () => {
        try {
            var id = 3;
            const response = await fetch(`http://localhost:8080/groupvote/${id}`);
            const jsonData = await response.json();
      
            setGameList(jsonData);
          } catch (err) {
            console.error(err.message);
          }
    };

    useEffect(() => {
        getGameList();    
    }, []);

    //upvote a game function
   const upvoteGame = async id => {
    try {
        let headers = new Headers();
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
                            <td>{each.game.gameName}</td>
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
