document.getElementById('descargarBtn').addEventListener('click', function() {
    // Obtener los datos de la tabla
    const tableData = [];
    const rows = document.querySelectorAll('#miTabla tr');

    rows.forEach(row => {
        const cols = row.querySelectorAll('td, th'); // Obtener tanto celdas como encabezados
        const rowData = Array.from(cols).map(col => col.innerText); // Obtener texto de cada celda
        tableData.push(rowData);
    });

    // Enviar los datos al servidor
    fetch('/download/pdf', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ tableData: tableData })
    })
    .then(response => {
        if (response.ok) {
            return response.blob(); // Obtener el blob de la respuesta
        }
        throw new Error('Error al descargar el PDF');
    })
    .then(blob => {
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.style.display = 'none';
        a.href = url;
        a.download = 'tabla.pdf'; // Nombre del archivo
        document.body.appendChild(a);
        a.click();
        window.URL.revokeObjectURL(url);
    })
    .catch(error => {
        console.error('Error:', error);
    });
});