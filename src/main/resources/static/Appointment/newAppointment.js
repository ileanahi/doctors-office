//const registerForm = document.getElementById('appointment-form')
//
//const newAppointmentConfig = {
//    baseUrl:'http://localhost:8080/api/appointments',
//    headers: {
//        'Content-Type':'application/json'
//    }
//}
//
//const handleSubmit = async (e) =>{
//    e.preventDefault()
//
//    let appointment = {
//            day: document.getElementById('day').value,
//            time: document.getElementById('time').value,
//            patient: model.patient,
//            doctor: model.doctor
//        },
//
//    console.log(appointment);
//
//    fetch('/addNewAppointment'), {
//        method:'POST',
//        body: JSON.stringify(appointment),
//        headers: {
//            'Content-Type': 'application/json',
//            },
//    })
//        .then(response => response.json())
//        .then (responseData)
//        .catch(err => console.error(err.message))
//
//    const responseArr = await response.json()
//        console.log(response)
//
//    if (response.status === 200){
//        console.log(response)
//
//        window.location.replace("http://localhost:8080/patient-profile.html")
//    }
//}
//
//appointment-form.addEventListener("submit", handleSubmit)