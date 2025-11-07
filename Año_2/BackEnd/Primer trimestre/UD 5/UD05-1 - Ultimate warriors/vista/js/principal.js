/*
    Título: UD05-1 - Ultimate warriors

    Autor: Carlos López Frieiro

    Data modificación: 21/11/2024

    Versión 1.0
*/

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('categoria').addEventListener('change', function () {
        var categoria = document.getElementById('categoria').value;
        var barbaro = document.getElementById('atrBarbaro');
        var clerigo = document.getElementById('atrClerigo');
        var bardo = document.getElementById('atrBardo');

        if (categoria == 'barbaro') {
            barbaro.style.display = 'block';
            clerigo.style.display = 'none';
            bardo.style.display = 'none';
        } else if (categoria == 'clerigo') {
            barbaro.style.display = 'none';
            clerigo.style.display = 'block';
            bardo.style.display = 'none';
        } else if (categoria == 'bardo') {
            barbaro.style.display = 'none';
            clerigo.style.display = 'none';
            bardo.style.display = 'block';
        } else {
            barbaro.style.display = 'none';
            clerigo.style.display = 'none';
            bardo.style.display = 'none';
        }
    });
});