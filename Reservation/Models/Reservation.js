const mongoose = require('mongoose');

const reservationSchema = new mongoose.Schema({
    name: {type: String, required: true},
    email: {type: String, required: true, unique: true},
    CheckIn: {type: String, required: true},
    CheckOut: {type: String, required: true},
    roomType: { type: String, required: true }
});

module.exports = mongoose.model('Reservation', reservationSchema);
