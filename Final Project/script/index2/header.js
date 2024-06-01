const hamburgerMenuIcon = document.querySelector('.hamburger-menu-icon-container');
const hamburgerMenu = document.querySelector('.hamburger-menu');
const hamoverlay = document.querySelector('.hamburgeroverlay'); 
const body = document.querySelector('body');
const drpdwn = document.getElementById('dropdown');
const menu = document.querySelector('.menu')
const drpmodel = document.getElementById('drpmodel');
const drpselect = document.getElementById('drpselect');
const drpview = document.getElementById('drpview');

drpdwn.addEventListener('click', () => 
{
    menu.classList.toggle('active');
    body.classList.toggle('scrolllock');
    modelnav.classList.remove('active');
    navoverlay.classList.toggle('active');
    selectcarnav.classList.remove('active');
});

drpmodel.addEventListener('click', () =>
{
    toggleActive(model, modelnav);
});

drpselect.addEventListener('click', () =>
{
    toggleActive(selectcar, selectcarnav);
});


hamburgerMenuIcon.addEventListener('click', () =>
{
    hamburgerMenuIcon.classList.toggle('active');
    hamburgerMenu.classList.toggle('active');
    hamoverlay.classList.toggle('active');
    body.classList.toggle('scrolllock');
});



hamoverlay.addEventListener('click', () =>
{
    hamburgerMenuIcon.classList.remove('active');
    hamburgerMenu.classList.remove('active');
    hamoverlay.classList.remove('active');
    body.classList.remove('scrolllock');
});

document.querySelector('.hamburger-menu').addEventListener('click', function(event) 
{
    event.stopPropagation();
});

function rotateFull()
{
    const element = document.querySelector('.hamburger-menu-icon');
    element.classList.remove('rotating');
    void element.offsetWidth;
    element.classList.toggle('rotating');
}

function rotateFull2()
{
    const element = document.getElementById('dropdown');
    element.classList.remove('rotating');
    void element.offsetWidth;
    element.classList.add('rotating');
}

const navoverlay = document.querySelector(".popular-cars-head-container");
const model = document.querySelector(".selector1");
const modelnav = document.querySelector(".modelnavigation");
const selectcar = document.querySelector(".selector2");
const selectcarnav = document.querySelector(".selectcarnavigation");
let activeElement = null;

function toggleActive(element, nav) {
    if (activeElement && activeElement !== element) {
        activeElement.classList.remove('active');
        const correspondingNav = getCorrespondingNav(activeElement);
        correspondingNav.classList.remove('active');
        navoverlay.classList.remove('active');
        body.classList.remove('scrolllock');
    }

    const isActive = element.classList.contains('active');
    element.classList.toggle('active', !isActive);
    nav.classList.toggle('active', !isActive);
    navoverlay.classList.toggle('active', !isActive);
    body.classList.toggle('scrolllock', !isActive);

    activeElement = !isActive ? element : null;
}

function getCorrespondingNav(element) {
    if (element === model) {
        return modelnav;
    } else if (element === selectcar) {
        return selectcarnav;
    }
}

model.addEventListener('click', () => 
{ 
    toggleActive(model, modelnav);
});

selectcar.addEventListener('click', () => 
{
    toggleActive(selectcar, selectcarnav);
});


navoverlay.addEventListener('click', () =>
{
    clearAll();
    menu.classList.toggle('active');
    navoverlay.classList.remove('active');
});

function clearAll() {
    if (activeElement) {
        activeElement.classList.remove('active');
        const correspondingNav = getCorrespondingNav(activeElement);
        correspondingNav.classList.remove('active');
        activeElement = null;
    }

    navoverlay.classList.remove('active');
    body.classList.remove('scrolllock');
    menu.classList.add('active');
}

document.addEventListener("DOMContentLoaded", function() 
{
    const goToAbout = document.getElementById("goToAbout");
    const goToServices = document.getElementById("goToServices");
    const goToCreator = document.getElementById("goToCreator");

    goToAbout.addEventListener("click", redirectToPage.bind(null, 'aboutPage'));
    goToServices.addEventListener("click", redirectToPage.bind(null, 'aboutServices'));
    goToCreator.addEventListener("click", redirectToPage.bind(null, 'aboutCreator'));

    function redirectToPage(page) 
    {
        window.location.href = `index.html?${page}=true`;
    }
});

function popularcarsfp()
{
    p1.classList.add('active');
    p2.classList.remove('active');
    p3.classList.remove('active');
    p4.classList.remove('active');
    p5.classList.remove('active');
    p6.classList.remove('active');
    p7.classList.remove('active');
    num1.classList.add('active');
    num2.classList.remove('active');
    num3.classList.remove('active');
    num4.classList.remove('active');
    num45.classList.remove('active');
    num5.classList.remove('active');
    num6.classList.remove('active');
    num7.classList.remove('active');
    nav2.classList.remove('active');
    nav1.classList.add('active');
    currentpage = 1;
}

