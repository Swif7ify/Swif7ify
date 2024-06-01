document.addEventListener("DOMContentLoaded", function() 
{
    const pages = document.querySelectorAll("#p1, #p2, #p3, #p4, #p5, #p6, #p7");

    pages.forEach(page => {
        page.addEventListener("click", redirectToPage.bind(null, page.id));
    });

    function redirectToPage(page) {
        window.location.href = `index2.html?${page}=true`;
    }
});

document.addEventListener("DOMContentLoaded", function() {
    const models = document.querySelectorAll("#goToaudi, #goTobmw, #goTochevrolet, #goToferrari, #goToford, #goTohonda, #goTomercedes, #goTonissan");

    models.forEach(model => {
        model.addEventListener("click", redirectToPage.bind(null, model.id));
    });

    function redirectToPage(page) {
        window.location.href = `index2.html?${page}=true`;
    }
});

document.addEventListener("DOMContentLoaded", function() {
    const urlParams = new URLSearchParams(window.location.search);

    switch(true)
    {
        case urlParams.has('eray'):
            setActiveCar(14);
            break;
        case urlParams.has('r8'):
            setActiveCar(4);
            break;
        case urlParams.has('ev'):
            setActiveCar(10);
            break;
    }
});

const carIds = [
    "a4", "q5", "a8", "r8", "bmw3", "bmw7", "x1", "x3", "z4", "ev", 
    "malibu", "equinox", "spark", "eray", "portofino", "lusso", 
    "roma", "superfast", "california", "escape", "fiesta", "focus", 
    "fusion", "mustanggt", "accord", "civic", "crv", "fit", "hrv", 
    "aclass", "cclass", "gla", "glc", "w223", "altima", "gtr", 
    "rogue", "sentra", "versa"
];

carIds.forEach((id, index) => {
    const car = document.getElementById(id);
    car.addEventListener("click", redirectToPage.bind(null, `cars${index + 2}`));
});

function redirectToPage(page) {
    window.location.href = `index3.html?${page}=true`;
}