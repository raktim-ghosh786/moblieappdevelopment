const mongoose = require('mongoose');
const mongo_uri=process.env.mongo_uri || 'mongodb://127.0.0.1:27017/raktimdb'

mongoose
    .connect(mongo_uri)
    .then(() => console.log("Connected"))
    .catch(() => console.log("Error"))

// auth schema
const authSchema = new mongoose.Schema({
    email: {
        type: String,
        required: true,
        unique: true
    },
    pass: {
        type: String,
        requied: true
    }
});

const auth = mongoose.model('auth', authSchema, 'creds'); // collection

module.exports = auth;