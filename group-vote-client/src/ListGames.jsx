import React, { Fragment, useEffect, useState } from "react";

const ListGames = () => {
    const [gameList, setGameList] = useState([]);
    const [gameNames, setGameNames] = useState([]);

    const getGameList = async () => {
        try {
            var id = 1;
            const response = await fetch(`http://localhost:8080/groupvote/${id}`);
            const jsonData = await response.json();
      
            setGameList(jsonData);
          } catch (err) {
            console.error(err.message);
          }
    };
    // const getGameNames = async () => {
    //     try {
    //         const response = await fetch(`http://localhost:8080/games`);
    //         const jsonData = await response.json();
    //         setGameNames(jsonData);
    //     } catch (err) {
    //         console.error(err.message);
    //     }
    // };

    // useEffect(() => {
    //     getGameNames();
        
    // }, []);
    useEffect(() => {
        getGameList();
    }, []);

    //upvote a game function
   const upvoteGame = async id => {
    try {
        let body = { id
          }
        const requestOptions = {
            method: 'PATCH',
            mode: 'no-cors',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        };
        await fetch(`http://localhost:8080/gamevote/upvote`, requestOptions)
          .then(response => response.json())
          .then(response => {
          if(response.status === "failed")
          alert(response.message)})

          //window.location = "/";
        // setServiceRequests(serviceRequests.filter(each => each.id !== id));
    } catch (err) {
      console.error(err.message);
    }
  };

    return (
        <Fragment>
            {" "}
            <table class="table mt-5 text-center">
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
                                    type="button" class="btn btn-success"
                                    onClick= {() => upvoteGame(each.id)}
                                    >
                                    I Want to Play
                                </button>
                            </td>
                            <td>
                                <button
                                    type="button" class="btn btn-danger"
                                    // onClick= {() => upvoteGame(each.id)}
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
