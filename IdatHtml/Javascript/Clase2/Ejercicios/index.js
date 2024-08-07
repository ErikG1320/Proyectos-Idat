document.addEventListener('DOMContentLoaded', function() {
    const display = document.getElementById('display');
    const buttons = document.querySelectorAll('.btn');
    let currentOperation = '';
    let operator = null;
    let operand1 = null;

    buttons.forEach(button => {
        button.addEventListener('click', function() {
            const value = this.getAttribute('data-num') || this.getAttribute('data-op');

            if (value) {
                if (['+', '-', '*', '/'].includes(value)) {
                    operator = value;
                    operand1 = parseFloat(display.value);
                    currentOperation = '';
                } else {
                    currentOperation += value;
                }
                display.value = currentOperation;
            } else if (this.id === 'equals') {
                if (operator && operand1 !== null) {
                    const operand2 = parseFloat(currentOperation);
                    let result;
                    switch (operator) {
                        case '+':
                            result = operand1 + operand2;
                            break;
                        case '-':
                            result = operand1 - operand2;
                            break;
                        case '*':
                            result = operand1 * operand2;
                            break;
                        case '/':
                            result = operand1 / operand2;
                            break;
                    }
                    display.value = result;
                    operand1 = null;
                    operator = null;
                    currentOperation = result;
                }
            } else if (this.id === 'clear') {
                display.value = '';
                currentOperation = '';
                operator = null;
                operand1 = null;
            } else if (this.id === 'inverse') {
                const number = parseFloat(display.value);
                if (number !== 0) {
                    display.value = 1 / number;
                    currentOperation = display.value;
                }
            }
        });
    });
});
