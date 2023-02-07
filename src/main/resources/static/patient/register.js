const registerForm = document.getElementById('register-form')

const registerConfig = {
    baseUrl:'http://localhost:8080/api/patient',
    headers: {
        'Content-Type':'application/json'
    }
}

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        name: document.getElementById('register-name').value,
        address: document.getElementById('register-address').value,
        email: document.getElementById('register-email').value,
        password: document.getElementById('register-password').value
    }

    const response = await fetch(`${registerConfig.baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: registerConfig.headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}

registerForm.addEventListener("submit", handleSubmit)