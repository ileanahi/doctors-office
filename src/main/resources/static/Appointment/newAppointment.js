const appointmentForm = document.getElementById('appointment-form')

console.log("INSIDE JAVASCRIPT")

const newAppointmentConfig = {
    baseUrl:'http://localhost:8080/api/appointments',
    headers: {
        'Content-Type':'application/json'
    }
}

//const doctorId = parseInt(document.getElementById('doctorId').value);
const doctorId = document.getElementById('doctorId').value;

const handleSubmit = async (e) =>{
    e.preventDefault()

    console.log(doctorId)

    console.log("inside handle submit")

    let appointment = {
            day: document.getElementById('day').value,
            time: document.getElementById('time').value,
            patientId: Number(document.getElementById('patientId').value),
            doctorId: Number(document.getElementById('doctorId').value)
        }

    console.log(appointment);

//    fetch('/new-appointment/{id}'), {
//        method:'POST',
//        body: JSON.stringify(appointment),
//        headers: {
//            'Content-Type': 'application/json',
//            },
//    })
//        .then(response => response.json())
//        .then (responseData)
//        .catch(err => console.error(err.message))

    let patientId = document.getElementById('patientId').value
    const response = await fetch(`${newAppointmentConfig.baseUrl}/${patientId}/newAppointment`,{
        method: "POST",
        body: JSON.stringify(appointment),
        headers: newAppointmentConfig.headers
    })

    const responseArr = await response.json()
        console.log(response)

    if (response.status === 200){
        console.log(response)

        window.location.replace("http://localhost:8080/patient-profile.html")
    }
}

appointmentForm.addEventListener("submit", handleSubmit)