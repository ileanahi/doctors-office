const appointmentForm = document.getElementById('appointment-form')

const newAppointmentConfig = {
    baseUrl:'http://localhost:8080/api/appointments',
    headers: {
        'Content-Type':'application/json'
    }
}

const handleSubmit = async (e) =>{
    e.preventDefault()

    let appointment = {
        appointmentDto:{
            day: document.getElementById('day').value,
            time: document.getElementById('time').value,
            patient: document.getElementById('patientId').value,
            doctor: document.getElementById('doctorId').value
        },

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
    const response = await fetch(`${newAppointmentConfig}/${patientId}/newAppointment`,{
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

appointment-form.addEventListener("submit", handleSubmit)