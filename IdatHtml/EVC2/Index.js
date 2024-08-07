// scripts.js
document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('vehicleForm');
    const plateInput = document.getElementById('placa');
    const typeSelect = document.getElementById('type');
    const amountDisplay = document.getElementById('amount');
    const totalVehiclesDisplay = document.getElementById('totalVehicles');
    const totalIncomeDisplay = document.getElementById('totalIncome');

    let totalVehicles = 0;
    let totalIncome = 0;

    const tariffs = {
        automovil: 6.60,
        motocicleta: 4.50,
        camion: 12.60
    };

    form.addEventListener('submit',(event) => {
        event.preventDefault();

        const placa = plateInput.value;
        const type = typeSelect.value;
        const amount = tariffs[type];

        totalVehicles++;
        totalIncome += amount;

        amountDisplay.textContent = `Monto a pagar: ${amount.toFixed(2)}`;
        totalVehiclesDisplay.textContent = `Total de vehículos registrados: ${totalVehicles}`;
        totalIncomeDisplay.textContent = `Total de ingresos generados: ${totalIncome.toFixed(2)}`;

        plateInput.value = '';
        typeSelect.value = 'automovil';
    });
});
