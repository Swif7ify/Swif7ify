const cars = document.querySelectorAll('.cars');


function setActiveCar(carIndex) {

    cars.forEach(car => car.classList.remove('active'));
    
    cars[carIndex].classList.add('active');
}

document.addEventListener("DOMContentLoaded", function() {
    const urlParams = new URLSearchParams(window.location.search);

    switch(true)
    {
        case urlParams.has('cars2'):
            setActiveCar(1);
            break;
        case urlParams.has('cars3'):
            setActiveCar(3);
            break;
        case urlParams.has('cars4'):
            setActiveCar(2);
            break;
        case urlParams.has('cars5'):
            setActiveCar(4);
            break;
        case urlParams.has('cars6'):
            setActiveCar(5);
            break;
        case urlParams.has('cars7'):
            setActiveCar(6);
            break;
        case urlParams.has('cars8'):
            setActiveCar(7);
            break;
        case urlParams.has('cars9'):
            setActiveCar(8);
            break;
        case urlParams.has('cars10'):
            setActiveCar(9);
            break;
        case urlParams.has('cars11'):
            setActiveCar(10);
            break;
        case urlParams.has('cars12'):
            setActiveCar(11);
            break;
        case urlParams.has('cars13'):
            setActiveCar(12);
            break;
        case urlParams.has('cars14'):
            setActiveCar(13);
            break;
        case urlParams.has('cars15'):
            setActiveCar(14);
            break;
        case urlParams.has('cars16'):
            setActiveCar(15);
            break;
        case urlParams.has('cars17'):
            setActiveCar(16);
            break;
        case urlParams.has('cars18'):
            setActiveCar(17);
            break;
        case urlParams.has('cars19'):
            setActiveCar(18);
            break;
        case urlParams.has('cars20'):
            setActiveCar(19);
            break;
        case urlParams.has('cars21'):
            setActiveCar(20);
            break;
        case urlParams.has('cars22'):
            setActiveCar(21);
            break;
        case urlParams.has('cars23'):
            setActiveCar(22);
            break;
        case urlParams.has('cars24'):
            setActiveCar(23);
            break;
        case urlParams.has('cars25'):
            setActiveCar(24);
            break;
        case urlParams.has('cars26'):
            setActiveCar(25);
            break;
        case urlParams.has('cars27'):
            setActiveCar(26);
            break;
        case urlParams.has('cars28'):
            setActiveCar(27);
            break;
        case urlParams.has('cars29'):
            setActiveCar(28);
            break;
        case urlParams.has('cars30'):
            setActiveCar(29);
            break;
        case urlParams.has('cars31'):
            setActiveCar(30);
            break;
        case urlParams.has('cars32'):
            setActiveCar(31);
            break;
        case urlParams.has('cars33'):
            setActiveCar(32);
            break;
        case urlParams.has('cars34'):
            setActiveCar(33);
            break;
        case urlParams.has('cars35'):
            setActiveCar(34);
            break;
        case urlParams.has('cars36'):
            setActiveCar(35);
            break;
        case urlParams.has('cars37'):
            setActiveCar(36);
            break;
        case urlParams.has('cars38'):
            setActiveCar(37);
            break;
        case urlParams.has('cars39'):
            setActiveCar(38);
            break;
        case urlParams.has('cars40'):
            setActiveCar(39);
            break;
    }
});

const toggled = document.querySelectorAll(".cars")

toggled.forEach(element =>
{
    element.onclick = function() 
    {
        this.classList.toggle('toggled');
    }
});

 