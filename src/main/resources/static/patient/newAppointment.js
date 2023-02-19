const registerForm = document.getElementById('appointment-form')

const registerConfig = {
    baseUrl:'http://localhost:8080/api/appointments',
    headers: {
        'Content-Type':'application/json'
    }
}

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        appointmentDto: {
            day: document.getElementById('day').value,
            time: document.getElementById('time').value,
            patient: document.getElementById('email').value,
        },
        id:
            document.getElementById('doctor-select').value
    }

    console.log(bodyObj);

    const response = await fetch(`${registerConfig.baseUrl}/registerForm`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: registerConfig.headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()
        console.log(response)

    if (response.status === 200){
        console.log(response)

        window.location.replace("http://localhost:8080/patient/login.html")
    }
}

registerForm.addEventListener("submit", handleSubmit)