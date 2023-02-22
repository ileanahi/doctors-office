// Get all the prescription table rows
const rows = document.querySelectorAll('table tr');

// Loop through the rows
rows.forEach(row => {
  // Get the columns of the current row
  const columns = row.querySelectorAll('td');

  // Check if the row has any columns
  if (columns.length > 0) {
    // Get the prescription information from the columns
    const date = columns[0].textContent;
    const patientName = columns[1].textContent;
    const prescription = columns[2].textContent;
    const filled = columns[3].textContent;

    // Log the prescription information to the console
    console.log(`Date: ${date}, Patient Name: ${patientName}, Prescription: ${prescription}, Filled: ${filled}`);
  }
});

