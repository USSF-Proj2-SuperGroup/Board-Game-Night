import React, { Fragment, useEffect, useState } from "react";

const ListGames = () => {
    const [gameList, setGameList] = useState([]);

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
                    {gameList.map(each => (
                        <tr key = {each.id}>
                            <td>{each.gameID}</td>
                            <td>{each.gameVotes}</td>
                            <td>
                                <button
                                    // onClick= {() => upvoteGame(each.id)}
                                    >

                                </button>
                            </td>
                            <td>
                                <button
                                    // onClick= {() => upvoteGame(each.id)}
                                    >

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
