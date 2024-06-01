document.addEventListener("DOMContentLoaded", function() {
    const urlParams = new URLSearchParams(window.location.search);

    switch(true)
    {
        case urlParams.has('aboutPage'):
            showAbout();
            break;
        case urlParams.has('aboutServices'):
            showServices();
            break;
        case urlParams.has('aboutCreator'):
            showCreator();
            break;
    }
});

document.addEventListener("DOMContentLoaded", function() 
{
    const eray = document.getElementById("eray");
    const r8 = document.getElementById("r8");
    const ev = document.getElementById("ev")

    eray.addEventListener("click", redirectToPage.bind(null, 'eray'));
    r8.addEventListener("click", redirectToPage.bind(null, 'r8'));
    ev.addEventListener("click", redirectToPage.bind(null, 'ev'));

    function redirectToPage(page) 
    {
        window.location.href = `index3.html?${page}=true`;
    }
});