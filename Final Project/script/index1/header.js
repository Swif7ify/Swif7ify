const container = document.getElementById("container");
const one = document.getElementById("one");
const two = document.getElementById("two");
const three = document.getElementById("three");
const four = document.getElementById("four");
const home = document.getElementById("home");
const about = document.getElementById("about");
const services = document.getElementById("services");
const creator = document.getElementById("creator");
const aboutPage = document.getElementById("aboutPage");
const navbar = document.querySelector(".nav-background");
const drpdwn = document.getElementById('dropdown');
const body = document.querySelector('body');

document.addEventListener('click', function(event) 
{
    const rightsection = document.querySelector(".right-section2");
    const targetElement = event.target;

    if (targetElement.classList.contains('hamburger-menu-icon') || rightsection.querySelector('.menu').contains(targetElement)) {
        rightsection.querySelector('.menu').classList.toggle('active');
      } else {
        rightsection.querySelector('.menu').classList.remove('active');
      }
});

function showHome()
{
    one.style.display = 'block';
    two.style.display = 'block';
    three.style.display = 'block';
    four.style.display = 'block';
    aboutPage.style.display = 'none';
    aboutServices.style.display = 'none';
    aboutCreator.style.display = 'none';
}

function showAbout()
{
    one.style.display = 'none';
    two.style.display = 'none';
    three.style.display = 'none';
    four.style.display = 'none';
    aboutPage.style.display = 'block';
    aboutServices.style.display = 'none';
    aboutCreator.style.display = 'none';
    home.classList.remove('active');
    about.classList.add('active');
    services.classList.remove('active');
    creator.classList.remove('active');
    navbar.classList.add('transparent-bg');
}

function showServices()
{
    one.style.display = 'none';
    two.style.display = 'none';
    three.style.display = 'none';
    four.style.display = 'none';
    aboutPage.style.display = 'none';
    aboutServices.style.display = 'block';
    aboutCreator.style.display = 'none';
    home.classList.remove('active');
    about.classList.remove('active');
    services.classList.add('active');
    creator.classList.remove('active');
    navbar.classList.add('transparent-bg');
}

function showCreator()
{
    one.style.display = 'none';
    two.style.display = 'none';
    three.style.display = 'none';
    four.style.display = 'none';
    aboutPage.style.display = 'none';
    aboutServices.style.display = 'none';
    aboutCreator.style.display = 'block';
    home.classList.remove('active');
    about.classList.remove('active');
    services.classList.remove('active');
    creator.classList.add('active');
    navbar.classList.add('transparent-bg');
}

function scrollToSection(sectionId) 
{
    const section = document.getElementById(sectionId);
    if (section) 
	{
        section.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
}

const buttons = document.querySelectorAll('.nav-button');
const sections = document.querySelectorAll('section');

buttons.forEach(button=> 
{
	button.addEventListener('click', () => 
	{
		const target = button.getAttribute('data-target');
      	sections.forEach(section => 
		{
        	if (section.id === target) 
			{
          		section.scrollIntoView({ behavior: 'smooth' });
          
                if(section.id === 'aboutPage')
                {
                    navbar.classList.add('transparent-bg');
                }

                else if(section.id === 'aboutServices')
                {
                    navbar.classList.add('transparent-bg');
                }

                else if(section.id === 'aboutCreator')
                {
                    navbar.classList.add('transparent-bg');
                }

                else
                {
                    navbar.classList.remove('transparent-bg');
                }
        }
		});
	buttons.forEach(btn => btn.classList.remove('active'));
	button.classList.add('active');
	});
});
  
const moveIcon = document.getElementById("moveIcon");

moveIcon.onclick = function()
{
	navbar.classList.remove('transparent-bg');
    buttons.forEach(item => 
	{
        item.classList.remove("active"); 
    });

	home.classList.add("active");
    showHome();
    scrollToSection('one');
};

document.getElementById('goToIndex2').onclick = function() 
{
    window.location.href = 'index2.html';
}


const lastscroll = 0;
const nav = document.querySelector(".nav-background");
window.addEventListener("scroll", function()
{
    const scrolltop = window.scrollY || this.document.documentElement.scrolltop;

    if(scrolltop > lastscroll)
    {
        nav.style.top = "-80px";
    }

    else
    {
        nav.style.top = "0";
    }
});


document.addEventListener('click', function(event) {
    const logocont = document.querySelector(".logo-cont");
    const targetElement = event.target;

    if (targetElement.classList.contains('showMore') || logocont.querySelector('.logoMenu').contains(targetElement)) {
        logocont.querySelector('.logoMenu').classList.toggle('active');
    } else {
        logocont.querySelector('.logoMenu').classList.remove('active');
    }
});

function rotateFull1()
{
    const element = document.getElementById('dropdown');
    element.classList.remove('rotating');
    void element.offsetWidth;
    element.classList.toggle('rotating');
}

function rotateFull2()
{
    const element = document.querySelector('.showMore');
    element.classList.remove('rotating');
    void element.offsetWidth;
    element.classList.toggle('rotating');
}
