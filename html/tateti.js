let currentPlayer = 'X';

function placeMarker(cell) {
    if (!cell.textContent) {
        currentPlayer = prompt("¿Qué marca quieres colocar: 'X' o 'O'?");
        if (currentPlayer === 'X' || currentPlayer === 'O') {
            cell.textContent = currentPlayer;
            checkWinner();
        } else {
            alert("Por favor, introduce 'X' o 'O'.");
        }
    }
}

function checkWinner() {
    const rows = document.querySelectorAll('.row');
    const winningCombos = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // Horizontal
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // Vertical
        [0, 4, 8], [2, 4, 6] // Diagonal
    ];

    for (const combo of winningCombos) {
        const [a, b, c] = combo;
        if (rows[a].children[0].textContent &&
            rows[a].children[0].textContent === rows[b].children[0].textContent &&
            rows[a].children[0].textContent === rows[c].children[0].textContent) {
            alert(`Player ${rows[a].children[0].textContent} wins!`);
            return;
        }
    }
}


// let currentPlayer = 'X';

// function placeMarker(cell) {
//     if (!cell.textContent) {
//         cell.textContent = currentPlayer;
//         checkWinner();
//         currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
//     }
// }

// function checkWinner() {
//     const rows = document.querySelectorAll('.row');
//     const winningCombos = [
//         [0, 1, 2], [3, 4, 5], [6, 7, 8], // Horizontal
//         [0, 3, 6], [1, 4, 7], [2, 5, 8], // Vertical
//         [0, 4, 8], [2, 4, 6] // Diagonal
//     ];

//     for (const combo of winningCombos) {
//         const [a, b, c] = combo;
//         if (rows[a].children[0].textContent &&
//             rows[a].children[0].textContent === rows[b].children[0].textContent &&
//             rows[a].children[0].textContent === rows[c].children[0].textContent) {
//             alert(`Player ${rows[a].children[0].textContent} wins!`);  // Línea corregida
//             return;
//         }
//     }
// }
