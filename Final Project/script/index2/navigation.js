document.addEventListener("DOMContentLoaded", function() {
    const carIds = [
        "a4", "q5", "a8", "r8", "bmw3", "bmw7", "x1", "x3", "z4", "ev", 
        "malibu", "equinox", "spark", "eray", "portofino", "lusso", 
        "roma", "superfast", "california", "escape", "fiesta", "focus", 
        "fusion", "mustanggt", "accord", "civic", "crv", "fit", "hrv", 
        "aclass", "cclass", "gla", "glc", "w223", "altima", "gtr", 
        "rogue", "sentra", "versa"
    ];

    const headerIds = [
        "pa4", "pq5", "pa8", "pr8", "pbmw3", "pbmw7", "px1", "px3", "pz4", "pev", 
        "pmalibu", "pequinox", "pspark", "peray", "pportofino", "plusso", 
        "proma", "psuperfast", "pcalifornia", "pescape", "pfiesta", "pfocus", 
        "pfusion", "pmustanggt", "paccord", "pcivic", "pcrv", "pfit", "phrv", 
        "paclass", "pcclass", "pgla", "pglc", "pw223", "paltima", "pgtr", 
        "progue", "psentra", "pversa"
    ];

    const subIds = [
        "sa4", "sq5", "sa8", "sr8", "sbmw3", "sbmw7", "sx1", "sx3", "sz4", "sev", 
        "smalibu", "sequinox", "sspark", "seray", "sportofino", "slusso", 
        "sroma", "ssuperfast", "scalifornia", "sescape", "sfiesta", "sfocus", 
        "sfusion", "smustanggt", "saccord", "scivic", "scrv", "sfit", "shrv", 
        "saclass", "scclass", "sgla", "sglc", "sw223", "saltima", "sgtr", 
        "srogue", "ssentra", "sversa"
    ];

    carIds.forEach((id, index) => {
        const car = document.getElementById(id);
        car.addEventListener("click", redirectToPage.bind(null, `cars${index + 2}`));
    });

    headerIds.forEach((id, index) => {
        const car = document.getElementById(id);
        car.addEventListener("click", redirectToPage.bind(null, `cars${index + 2}`));
    });

    subIds.forEach((id, index) => {
        const car = document.getElementById(id);
        car.addEventListener("click", redirectToPage.bind(null, `cars${index + 2}`));
    });

    function redirectToPage(page) {
        window.location.href = `index3.html?${page}=true`;
    }
});

function goToP1()
{
    p1.classList.add('active');
    p2.classList.remove('active');
    p3.classList.remove('active');
    p4.classList.remove('active');
    p5.classList.remove('active');
    p6.classList.remove('active');
    p7.classList.remove('active');
    nav1.classList.add('active');
    nav2.classList.remove('active');
    currentpage = 2;
    bckbtn();
}

function goToP2()
{
    p1.classList.remove('active');
    p2.classList.add('active');
    p3.classList.remove('active');
    p4.classList.remove('active');
    p5.classList.remove('active');
    p6.classList.remove('active');
    p7.classList.remove('active');
    num1.classList.remove('active');
    num2.classList.add('active');
    num3.classList.remove('active');
    num4.classList.remove('active');
    num5.classList.remove('active');
    num6.classList.remove('active');
    num7.classList.remove('active');
    nav1.classList.add('active');
    nav2.classList.remove('active');
    currentpage = 2;
}

function goToP3()
{
    p1.classList.remove('active');
    p2.classList.remove('active');
    p3.classList.add('active');
    p4.classList.remove('active');
    p5.classList.remove('active');
    p6.classList.remove('active');
    p7.classList.remove('active');
    num1.classList.remove('active');
    num2.classList.remove('active');
    num3.classList.add('active');
    num4.classList.remove('active');
    num5.classList.remove('active');
    num6.classList.remove('active');
    num7.classList.remove('active');
    nav1.classList.add('active');
    nav2.classList.remove('active');
    currentpage = 3;
}

function goToP4()
{
    p1.classList.remove('active');
    p2.classList.remove('active');
    p3.classList.remove('active');
    p4.classList.add('active');
    p5.classList.remove('active');
    p6.classList.remove('active');
    p7.classList.remove('active');
    num1.classList.remove('active');
    num2.classList.remove('active');
    num3.classList.remove('active');
    num4.classList.remove('active');
    num45.classList.add('active');
    num5.classList.remove('active');
    num6.classList.remove('active');
    num7.classList.remove('active');
    nav2.classList.add('active');
    nav1.classList.remove('active');
    currentpage = 4;
}

function goToP5()
{
    p1.classList.remove('active');
    p2.classList.remove('active');
    p3.classList.remove('active');
    p4.classList.remove('active');
    p5.classList.add('active');
    p6.classList.remove('active');
    p7.classList.remove('active');
    num1.classList.remove('active');
    num2.classList.remove('active');
    num3.classList.remove('active');
    num4.classList.remove('active');
    num45.classList.remove('active');
    num5.classList.add('active');
    num6.classList.remove('active');
    num7.classList.remove('active');
    nav1.classList.remove('active');
    nav2.classList.add('active');
    currentpage = 5;
}

function goToP6()
{
    p1.classList.remove('active');
    p2.classList.remove('active');
    p3.classList.remove('active');
    p4.classList.remove('active');
    p5.classList.remove('active');
    p6.classList.add('active');
    p7.classList.remove('active');
    num1.classList.remove('active');
    num2.classList.remove('active');
    num3.classList.remove('active');
    num4.classList.remove('active');
    num45.classList.remove('active');
    num5.classList.remove('active');
    num6.classList.add('active');
    num7.classList.remove('active');
    nav2.classList.add('active');
    nav1.classList.remove('active');
    currentpage = 6;    
}

function goToP7()
{
    p1.classList.remove('active');
    p2.classList.remove('active');
    p3.classList.remove('active');
    p4.classList.remove('active');
    p5.classList.remove('active');
    p6.classList.remove('active');
    p7.classList.add('active');
    num1.classList.remove('active');
    num2.classList.remove('active');
    num3.classList.remove('active');
    num4.classList.remove('active');
    num45.classList.remove('active');
    num5.classList.remove('active');
    num6.classList.remove('active');
    num7.classList.add('active');
    nav2.classList.add('active');
    nav1.classList.remove('active');
    currentpage = 7;
}

document.addEventListener("DOMContentLoaded", function() {
    const urlParams = new URLSearchParams(window.location.search);

    switch(true)
    {
        case urlParams.has('p1'):
            goToP1();
            break;
        case urlParams.has('p2'):
            goToP2();
            break;
        case urlParams.has('p3'):
            goToP3();
            break;
        case urlParams.has('p4'):
            goToP4();
            break;
        case urlParams.has('p5'):
            goToP5();
            break;
        case urlParams.has('p6'):
            goToP6();
            break;
        case urlParams.has('p7'):
            goToP7();
            break;
    }
});