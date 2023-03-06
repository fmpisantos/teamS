import React, { useState, useRef, useEffect } from "react";

const Snake = () => {
  const [gameStarted, setGameStarted] = useState(false);
  const canvasRef = useRef(null);

  useEffect(() => {
    if (!gameStarted) {
      return;
    }

    const canvas = canvasRef.current;
    const ctx = canvas.getContext("2d");

    // Set the size of the canvas
    canvas.height = 500;
    canvas.width = 800;

    // Initialize the snake
    let snake = [
        { x: 140, y: 140 },
        { x: 120, y: 140 },
        { x: 100, y: 140 },
        { x: 80, y: 140 },
        { x: 60, y: 140 }
    ];
    let direction = "right";
    let fruit = { x: 200, y: 200 };

    // Draw the fruit
    const drawFruit = () => {
      ctx.fillStyle = "red";
      ctx.fillRect(fruit.x, fruit.y, 20, 20);
    };

    // Draw the snake
    const drawSnake = () => {
      for (let i = 0; i < snake.length; i++) {
        ctx.fillStyle = i === 0 ? "green" : "white";
        ctx.fillRect(snake[i].x, snake[i].y, 20, 20);
        ctx.strokeStyle = "red";
        ctx.strokeRect(snake[i].x, snake[i].y, 20, 20);
      }
    };

    // Move the snake
    const moveSnake = () => {
      let x = snake[0].x;
      let y = snake[0].y;

      if (direction === "right") {
        x += 20;
      } else if (direction === "left") {
        x -= 20;
      } else if (direction === "up") {
        y -= 20;
      } else if (direction === "down") {
        y += 20;
      }

      // Check if the snake has eaten the fruit
      if (x === fruit.x && y === fruit.y) {
        snake.unshift({ x, y });
        fruit = {
          x: Math.floor(Math.random() * (canvas.width / 20)) * 20,
          y: Math.floor(Math.random() * (canvas.height / 20)) * 20
        };
      } else {
        snake.pop();
        snake.unshift({ x, y });
      }

      // Check for game over
      if( canvas.width < snake[0].x ||snake[0].x < 0  || canvas.height < snake[0].y || snake[0].y < 0)
      {
        setGameStarted(false);
        return;
      }

      for (let i = 1; i < snake.length; i++) {
        if (x === snake[i].x && y === snake[i].y) {
          setGameStarted(false);
          return;
        }
      }

      // Clear the canvas
      ctx.clearRect(0, 0, canvas.width, canvas.height);

      // Draw the snake and fruit
      drawFruit();
      drawSnake();
    };

    // Handle key events
    const handleKeyDown = event => {
      if (event.keyCode === 37 && direction !== "right") {
        direction = "left";
      } else if (event.keyCode === 38 && direction !== "down") {
        direction = "up";
      } else if (event.keyCode === 39 && direction !== "left") {
        direction = "right";
      } else if (event.keyCode === 40 && direction !== "up") {
        direction = "down";
      }
    };

    document.addEventListener("keydown", handleKeyDown);

    // Start the game loop
    const gameLoop = setInterval(() => {
      moveSnake();
    }, 100);

    return () => {
      clearInterval(gameLoop);
      document.removeEventListener("keydown", handleKeyDown);
    };
  }, [gameStarted]);

  const startGame = () => {
    setGameStarted(true);
  };

  const restartGame = () => {
    setGameStarted(false);
    setTimeout(() => {
      setGameStarted(true);
    }, 100);
  };

  const styles = {
    container: {
      display: "flex",
      flexDirection: "column",
      alignItems: "center",
      justifyContent: "center",
      height: "80vh",
      width: "100vw"
    },
    canvas: {
      border: "1px solid black",
      backgroundColor: "#eee",
      height: 500,
      width: 800
    },
    buttonsContainer: {
      display: "flex",
      justifyContent: "center"
    },
    button: {
      padding: 10,
      borderRadius: 5,
      backgroundColor: "black",
      color:"white",
      border: "none",
      cursor: "pointer",
      fontSize: 18,
      margin: 10
    }
  };

  return (
    <div style={styles.container}>
      <canvas ref={canvasRef} style={styles.canvas} />
      <div style={styles.buttonsContainer}>
        {!gameStarted && (
          <button style={styles.button} onClick={startGame}>
            Start Game
          </button>
        )}
        {gameStarted && (
          <button style={styles.button} onClick={restartGame}>
            Restart Game
          </button>
        )}
      </div>
    </div>
  );
};

export default Snake;

