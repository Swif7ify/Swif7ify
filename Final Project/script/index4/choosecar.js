const addcars = document.getElementById("adcars1");
const addcars2 = document.getElementById("adcars2");
const ac1 = addcars.querySelector('p');
const ac2 = addcars2.querySelector('p');
const cont1 = document.querySelector(".choose-cont");
const cont2 = document.querySelector(".choose-cont2");
const title = document.getElementById("titled");
const ab = document.querySelector(".cont1");
const bc = document.querySelector(".cont2")

addcars.addEventListener("click", () =>
{
    addcars.classList.toggle('active');
    ac1.classList.toggle('active');
    cont1.classList.toggle('active');
});

addcars2.addEventListener("click", () =>
    {
        addcars2.classList.toggle('active');
        ac2.classList.toggle('active');
        cont2.classList.toggle('active'); 
    });

document.addEventListener("click", function(event){
    const car2Ids = [
        "wa3", "wa4", "wq5", "wa8", "wr8", "wbmw3", "wbmw7", "wx1", "wx3", "wz4", "wev", 
        "wmalibu", "wequinox", "wspark", "weray", "wportofino", "wlusso", 
        "wroma", "wsuperfast", "wcalifornia", "wescape", "wfiesta", "wfocus", 
        "wfusion", "wmustanggt", "waccord", "wcivic", "wcrv", "wfit", "whrv", 
        "waclass", "wcclass", "wgla", "wglc", "ww223", "waltima", "wgtr", 
        "wrogue", "wsentra", "wversa"
    ];

    if (car2Ids.includes(event.target.id)) {
        const carIndex = car2Ids.indexOf(event.target.id);
        setActiveCar2(carIndex);
        cont2.style.display = 'none';
        addcars2.style.display = 'none';
        if (addcars.classList.contains('active')) {
            addcars.classList.remove('active');
        }
    }
});

document.addEventListener("click", function(event){
    const carIds = [
        "qa3", "qa4", "qq5", "qa8", "qr8", "qbmw3", "qbmw7", "qx1", "qx3", "qz4", "qev", 
        "qmalibu", "qequinox", "qspark", "qeray", "qportofino", "qlusso", 
        "qroma", "qsuperfast", "qcalifornia", "qescape", "qfiesta", "qfocus", 
        "qfusion", "qmustanggt", "qaccord", "qcivic", "qcrv", "qfit", "qhrv", 
        "qaclass", "qcclass", "qgla", "qglc", "qw223", "qaltima", "qgtr", 
        "qrogue", "qsentra", "qversa"
    ];
    
    if (carIds.includes(event.target.id)) { 
        const carIndex = carIds.indexOf(event.target.id);
        setActiveCar(carIndex);
        cont1.style.display = 'none';
        addcars.style.display = 'none';
        if (addcars.classList.contains('active')) {
            addcars.classList.remove('active');
        }
    }
});

ab.addEventListener('click', () =>
{
        ab.classList.toggle('active');
});
    
bc.addEventListener('click', () =>{
        bc.classList.toggle('active');
});

const cars = document.querySelectorAll('.cars');
const cars2 = document.querySelectorAll('.carsa');

function setActiveCar(carIndex) {
    cars.forEach(car => car.classList.remove('active'));
    cars[carIndex].classList.add('active');
}

function setActiveCar2(carIndex) {
    cars2.forEach(car => car.classList.remove('active'));
    cars2[carIndex].classList.add('active');
}

function exit1()
{
    cont1.style.display = 'flex';
    cont1.classList.remove('active');
    addcars.style.display = 'flex';
    cars.forEach(car => car.classList.remove('active')); 
}

function exit2()
{
    cont2.style.display = 'flex';
    cont2.classList.remove('active');
    addcars2.style.display = 'flex';
    cars2.forEach(car => car.classList.remove('active')); 
}