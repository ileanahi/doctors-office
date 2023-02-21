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

const patientEmail = document.getElementById("patientName").value;
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
  editAddressLinkEl.removeEventListener('click', arguments.callee);
});

async function handleSaveClick(event) {

  event.preventDefault();
  addressEl.contentEditable = false;
  const newAddress = addressEl.innerHTML;

    console.log("inside handlesave")

    let bodyUpdate = {
        id: patientId,
        name: patientName,
        email: patientEmail,
        password: "123",
        address: patientAddress,
    }

    console.log(bodyUpdate)
    const response = await fetch(`${patientConfig.baseUrl}/${patientId}`, {
        method: "PUT",
        body: JSON.stringify(bodyUpdate),
        headers: staffConfig.headers
    });

    if (response.ok) {
        console.log(response)
        console.log("Staff updated!");
        window.location.reload();
    } else {
        console.error("Failed to update staff.");
    }


  editAddressLinkEl.innerHTML = "[edit]";
  editAddressLinkEl.removeEventListener('click', arguments.callee);
  editAddressLinkEl.addEventListener('click', handleEditClick);
}
//














//addressEl.addEventListener('keydown', (event) => {
//  if (event.keyCode === 13) { // enter key
//    event.preventDefault();
//    addressEl.contentEditable = false;


//    const response = await fetch(`${patientConfig.baseUrl}/${patientId}`, {
//        method: "PUT",
//        body: JSON.stringify(bodyUpdate),
//        headers: staffConfig.headers
//    });
//
//
//    if (response.ok) {
//        console.log(response)
//        console.log("Staff updated!");
//        window.location.reload();
//    } else {
//        console.error("Failed to update staff.");
//    }


//  }
//});