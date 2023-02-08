let loginForm = document.getElementById('login-form')
let loginEmail = document.getElementById('login-email')
let loginPassword = document.getElementById('login-password')

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/patient'

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        email: loginEmail.value,
        password: loginPassword.value
    }
    console.log(bodyObj);

    const response = await fetch(`${baseUrl}/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
    console.log(response)

//    window.location.replace(response.url);


    if (response.status === 200){

        let data = await response.json()
            let id = data[1]
//            let id2 = data[0]

            console.log(typeof id)
            let idLong = parseInt(id)
            console.log(typeof idLong)
            document.cookie = `userId=${id}`
            window.location.replace('http://localhost:8080/patientView/' + id)
    }
}

loginForm.addEventListener("submit", handleSubmit)