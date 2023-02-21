console.log("javascript!")

const patientConfig = {
    baseUrl:'http://localhost:8080/api/patient',
    headers: {
        'Content-Type':'application/json'
    }
}

const patientId = document.getElementById('patientId').value;
const addressEl = document.getElementById('address');
const editAddressLinkEl = document.getElementById('edit-address-link');
console.log(patientId)
console.log(addressEl)


const patientName = document.getElementById('patientName').textContent;
const patientEmail = document.getElementById('patientEmail').value;
const patientAddress = addressEl.textContent;
console.log(patientAddress)
console.log(patientName)
console.log(patientEmail)


editAddressLinkEl.addEventListener('click', async (event) => {
  event.preventDefault();
  addressEl.contentEditable = true;
  addressEl.focus();
  editAddressLinkEl.innerHTML = "[save]";
  editAddressLinkEl.addEventListener('click', handleSaveClick);
  editAddressLinkEl.removeEventListener('click', handleEditClick);
});

async function handleSaveClick(event) {

  event.preventDefault();
  addressEl.contentEditable = false;

  const newAddress = addressEl.textContent;
  console.log(newAddress)

    console.log("inside handlesave")

    let bodyUpdate = {
        id: patientId,
        name: patientName,
        email: patientEmail,
        password: "123",
        address: newAddress,
    }

    console.log(bodyUpdate)
    const response = await fetch(`${patientConfig.baseUrl}/${patientId}`, {
        method: "PUT",
        body: JSON.stringify(bodyUpdate),
        headers: patientConfig.headers
    });

    if (response.ok) {
        console.log(response)
        console.log("Patient updated!");
        window.location.reload();
    } else {
        console.error("Failed to update patient.");
    }


  editAddressLinkEl.innerHTML = "[edit]";
  editAddressLinkEl.removeEventListener('click', arguments.callee);
  editAddressLinkEl.addEventListener('click', handleEditClick);
}


async function handleEditClick(event) {
    event.preventDefault();
    addressEl.contentEditable = false;
    editAddressLinkEl.innerHTML = "[edit]";
    editAddressLinkEl.addEventListener('click', handleEditClick);
    editAddressLinkEl.removeEventListener('click', handleSaveClick);
  }














//addressEl.addEventListener('keydown', (event) => {
//  if (event.keyCode === 13) { // enter key
//    event.preventDefault();
//    addressEl.contentEditable = false;


//    const response = await fetch(`${patientConfig.baseUrl}/${patientId}`, {
//        method: "PUT",
//        body: JSON.stringify(bodyUpdate),
//        headers: patientConfig.headers
//    });
//
//
//    if (response.ok) {
//        console.log(response)
//        console.log("Patient updated!");
//        window.location.reload();
//    } else {
//        console.error("Failed to update patient.");
//    }


//  }
//});