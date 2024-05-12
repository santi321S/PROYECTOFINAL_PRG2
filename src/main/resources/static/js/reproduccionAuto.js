const sourceElements = document.querySelectorAll("source");

const srcList = [];

sourceElements.forEach((sourceElement) => {
    const srcValue = sourceElement.getAttribute("src");
    srcList.push(srcValue);
});

console.log(srcList);
const reproductor = document.getElementById('miReproductor');
const pistas = srcList;
let indiceActual = 0;

reproductor.addEventListener('ended', () => {
    indiceActual = (indiceActual + 1) % pistas.length;
    reproductor.src = pistas[indiceActual];
    reproductor.play();
});