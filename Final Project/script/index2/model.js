function handleCarClick(containerIndex) 
{
    const containers = document.querySelectorAll('.modelcontainer');
    containers.forEach(container => container.classList.remove('active'));
    containers[containerIndex].classList.add('active');
    nav.classList.add('active');

    const defaultDisplayElements = document.querySelectorAll('.DC');
    defaultDisplayElements.forEach(element => element.style.display = 'none');
}

document.getElementById('goToaudi').addEventListener('click', () => handleCarClick(0));
document.getElementById('goTobmw').addEventListener('click', () => handleCarClick(1));
document.getElementById('goTochevrolet').addEventListener('click', () => handleCarClick(2));
document.getElementById('goToferrari').addEventListener('click', () => handleCarClick(3));
document.getElementById('goToford').addEventListener('click', () => handleCarClick(4));
document.getElementById('goTohonda').addEventListener('click', () => handleCarClick(5));
document.getElementById('goTomercedes').addEventListener('click', () => handleCarClick(6));
document.getElementById('goTonissan').addEventListener('click', () => handleCarClick(7));
const nav = document.querySelector(".navigation");

document.addEventListener("DOMContentLoaded", function() {
    const urlParams = new URLSearchParams(window.location.search);

    switch(true)
    {
        case urlParams.has('goToaudi'):
            handleCarClick(1);
            break;
        case urlParams.has('goTobmw'):
            handleCarClick(2);
            break;
        case urlParams.has('goTochevrolet'):
            handleCarClick(2);
            break;
        case urlParams.has('goToferrari'):
            handleCarClick(3);
            break;
        case urlParams.has('goToford'):
            handleCarClick(4);
            break;
        case urlParams.has('goTohonda'):
            handleCarClick(5);
            break;
        case urlParams.has('goTomercedes'):
            handleCarClick(6);
            break;
        case urlParams.has('goTonissan'):
            handleCarClick(7);
            break;
    }
});