import React, { Fragment, useEffect, useState } from "react";

const ListGames = () => {
    const [gameList, setGameList] = useState([]);

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

    useEffect(() => {
        getGameList();
    }, []);

    return (
        <Fragment>
            {" "}
            <table>
                <thead>
                    <tr>
                        <th>Game Name</th>
                        <th>Vote</th>
                        <th>Up Vote</th>
                        <th>Down Vote</th>
                    </tr>
                </thead>
                <tbody>
                    {gamesList.map(each => (
                        <tr key = {each.Pool_ID}>
                            <td>{each.Game_ID}</td>
                            <td>{each.Game_votes}</td>
                            <td>
                                <button
                                    onClick= {() => upvoteGame(each.Pool_ID)}>

                                </button>
                            </td>
                            <td>
                                <button
                                    onClick= {() => upvoteGame(each.Pool_ID)}>

                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </Fragment>
    )

}
