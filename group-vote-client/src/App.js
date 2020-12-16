import React, { Fragment } from "react";
import ListGames from "./ListGames";

function App() {
  return (
    <div>
      <div class="container">
        <div class="jumbotron">
          <h1>Game Vote Client</h1>
          <p>Vote on your favorite game to play.</p>
        </div>
      </div>
      <ListGames></ListGames>
      
    </div>
  );
}

export default App;
