const express = require('express');
const router = express.Router();
const Reservation = require('../Models/Reservation');

// Obtener todas las reservaciones
router.get('/', async (req, res) => {
    try {
        const reservations = await Reservation.find();
        res.json(reservations);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});

// Crear una nueva reservación
router.post('/', async (req, res) => {
    const reservation = new Reservation({
        name: req.body.name,
        date: req.body.date,
        time: req.body.time,
        numberOfGuests: req.body.numberOfGuests
    });

    try {
        const newReservation = await reservation.save();
        res.status(201).json(newReservation);
    } catch (error) {
        res.status(400).json({ message: error.message });
    }
});

// Actualizar una reservación por ID
router.put('/:id', async (req, res) => {
    try {
        const updatedReservation = await Reservation.findByIdAndUpdate(req.params.id, req.body, { new: true });
        res.json(updatedReservation);
    } catch (error) {
        res.status(400).json({ message: error.message });
    }
});

// Eliminar una reservación por ID
router.delete('/:id', async (req, res) => {
    try {
        await Reservation.findByIdAndDelete(req.params.id);
        res.status(204).send();
    } catch (error) {
        res.status(400).json({ message: error.message });
    }
});

module.exports = router;
