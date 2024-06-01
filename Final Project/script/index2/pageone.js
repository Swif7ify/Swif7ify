const p1 = document.querySelector(".p1");
const p2 = document.querySelector(".p2");
const p3 = document.querySelector(".p3");
const p4 = document.querySelector(".p4");
const p5 = document.querySelector(".p5");
const p6 = document.querySelector(".p6");
const p7 = document.querySelector(".p7");

const num1 = document.querySelector(".n1");
const num2 = document.querySelector(".n2");
const num3 = document.querySelector(".n3");
const num4 = document.querySelector(".n4");
const num45 = document.querySelector(".n45");
const num5 = document.querySelector(".n5");
const num6 = document.querySelector(".n6");
const num7 = document.querySelector(".n7");

const nav1 = document.querySelector(".navigation1-numbers");
const nav2 = document.querySelector(".navigation2-numbers");

let currentpage = 1;

function nextbtn() 
{
    if(currentpage > 7)
    {
        currentpage = 7;
    }

    else if(currentpage <1)
    {
        currentpage = 1;
    }
    
    currentpage++
    switch(currentpage)
    {
        case 1:
            p1.classList.add('active');
            p2.classList.remove('active');
            p3.classList.remove('active');
            p4.classList.remove('active');
            p5.classList.remove('active');
            p6.classList.remove('active');
            p7.classList.remove('active');
            nav1.classList.add('active');
            nav2.classList.remove('active');
            break;
        case 2:
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
            break;
        case 3:
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
            break;
        case 4: 
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
            break;
        case 5:
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
            break;
        case 6:
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
            break;
        case 7:
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
            break;
    }
}

function bckbtn() 
{
    if(currentpage < 1)
    {
        currentpage = 1;
    }

    else if(currentpage >7)
    {
        currentpage = 7;
    }

    currentpage--
    switch(currentpage)
    {
        case 1:
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
            break;
        case 2:
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
            num45.classList.remove('active');
            num5.classList.remove('active');
            num6.classList.remove('active');
            num7.classList.remove('active');
            break;
        case 3:
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
            num45.classList.remove('active');
            num5.classList.remove('active');
            num6.classList.remove('active');
            num7.classList.remove('active');
            nav1.classList.add('active');
            nav2.classList.remove('active');
            break;
        case 4: 
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
            num4.classList.add('active');
            num45.classList.remove('active');
            num5.classList.remove('active');
            num6.classList.remove('active');
            num7.classList.remove('active');
            nav2.classList.remove('active');
            nav1.classList.add('active');
            break;
        case 5:
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
            break;
        case 6:
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
            break;
        case 7:
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
            break;
    }
}

num1.onclick = function()
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

num2.onclick = function()
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

num3.onclick = function()
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

num4.onclick = function()
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

num45.onclick = function()
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
    num4.classList.add('active');
    num45.classList.remove('active');
    num5.classList.remove('active');
    num6.classList.remove('active');
    num7.classList.remove('active');
    nav1.classList.add('active');
    nav2.classList.remove('active');
    currentpage = 4;
}

num5.onclick = function()
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

num6.onclick = function()
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

num7.onclick = function()
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
