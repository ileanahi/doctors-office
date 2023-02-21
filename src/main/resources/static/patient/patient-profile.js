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
const phoneEl = document.getElementById('phone');
console.log(phoneEl.textContent)


const patientName = document.getElementById('patientName').textContent;
const patientEmail = document.getElementById('patientEmail').value;
const patientAddress = addressEl.textContent;
console.log(patientAddress)
console.log(patientName)
console.log(patientEmail)


///////////////////////// EDIT THE ADDRESS ////////////////////////////
editAddressLinkEl.addEventListener('click', async (event) => {
  event.preventDefault();
  addressEl.contentEditable = true;
  addressEl.focus();
  editAddressLinkEl.innerHTML = "[save]";
  editAddressLinkEl.addEventListener('click', handleSaveAddressClick);
  editAddressLinkEl.removeEventListener('click', handleEditAddressClick);
});

async function handleSaveAddressClick(event) {

  event.preventDefault();
  addressEl.contentEditable = false;

  const newAddress = addressEl.textContent;
  console.log(newAddress)

    console.log("inside handlesave")

    let addressUpdate = {
        id: patientId,
        name: patientName,
        phone: phoneEl.textContent,
        email: patientEmail,
        password: "123",
        address: newAddress,
    }

    console.log(addressUpdate)
    const response = await fetch(`${patientConfig.baseUrl}/${patientId}`, {
        method: "PUT",
        body: JSON.stringify(addressUpdate),
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
  editAddressLinkEl.addEventListener('click', handleEditAddressClick);
}


async function handleEditAddressClick(event) {
    event.preventDefault();
    addressEl.contentEditable = false;
    editAddressLinkEl.innerHTML = "[edit]";
    editAddressLinkEl.addEventListener('click', handleEditAddressClick);
    editAddressLinkEl.removeEventListener('click', handleSaveAddressClick);
}





////////////////////////// EDIT PHONE NUMBER ///////////////////////////
const editPhoneLinkEl = document.getElementById('edit-phone-link');

editPhoneLinkEl.addEventListener('click', async (event) => {
  event.preventDefault();
  phoneEl.contentEditable = true;
  phoneEl.focus();
  editPhoneLinkEl.innerHTML = "[save]";
  editPhoneLinkEl.addEventListener('click', handleSavePhoneClick);
  editPhoneLinkEl.removeEventListener('click', handleEditPhoneClick);
});

async function handleSavePhoneClick(event) {

  event.preventDefault();
  phoneEl.contentEditable = false;

  const newPhone = phoneEl.textContent;
  console.log(newPhone)

    console.log("inside handlesave")

    let phoneUpdate = {
        id: patientId,
        name: patientName,
        email: patientEmail,
        phone: newPhone,
        password: "123",
        address: patientAddress,
    }

    console.log(phoneUpdate)
    const response = await fetch(`${patientConfig.baseUrl}/${patientId}`, {
        method: "PUT",
        body: JSON.stringify(phoneUpdate),
        headers: patientConfig.headers
    });

    if (response.ok) {
        console.log(response)
        console.log("Patient updated!");
        window.location.reload();
    } else {
        console.error("Failed to update patient.");
    }


  editPhoneLinkEl.innerHTML = "[edit]";
  editPhoneLinkEl.removeEventListener('click', arguments.callee);
  editPhoneLinkEl.addEventListener('click', handleEditPhoneClick);
}


async function handleEditPhoneClick(event) {
    event.preventDefault();
    phoneEl.contentEditable = false;
    editPhoneLinkEl.innerHTML = "[edit]";
    editPhoneLinkEl.addEventListener('click', handleEditPhoneClick);
    editPhoneLinkEl.removeEventListener('click', handleSavePhoneClick);
}


