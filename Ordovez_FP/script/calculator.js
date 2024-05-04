let answer = 0;

document.addEventListener('keydown', function(event)
{
    if(event.ctrlKey && event.key === "Backspace")
    {
        clearinputs();
    }
});

document.addEventListener("keypress", function(event) {
    if (event.key === "Enter") 
    {
        calculate();
    }

    else if(event.key >= '0' && event.key <= '9' || event.key === '+' || event.key === '-' || event.key === '/' || event.key === '.' || event.key === '*' || event.key === '(' || event.key === ')' || event.key === '%' || event.key === '!' || event.key === '^' || event.key === 'x' || event.key === '=' || event.key === 'l' || event.key === 'o' || event.key === 'g' || event.key === 's' ||event.key === 'i' || event.key === 'n' || event.key === 'c' || event.key === 't' || event.key === 'a' || event.key === 'n' || event.key === 'p' || event.key === 'z')
    { 
        if(event.key === 'x')
        {
            inputs.value += '×';
            int.value += '*';
        }

        else if(event.key === '*')
        {
            inputs.value += '×';
            int.value += '*';
        }

        else if(event.key === '=')
        {
            calculate();
        }

        else if(event.key === '^')
        {
            inputs.value += '^(';
            int.value += '^(';
        }

        else if(event.key === '/')
        {
            inputs.value += '÷';
            int.value += '/';
        }

        else if(event.key === 'z')
        {
            remindercontainer.classList.toggle('active');
            overlay.classList.toggle('active');
            container.classList.toggle('active');   
        }

        else 
        {
            inputs.value += event.key;
            int.value += event.key;
        }
    }
});

document.addEventListener('keydown', function(event)
{
    if(event.key === "Backspace")
    {
        del();
    }

    else if(event.key ==="Delete")
    {
        clearinputs();
    }

    else if(event.key === 'v')
    {
        second.classList.toggle('active');
        number2.classList.toggle('active');
        number.classList.toggle('active');
    }

    else if(event.key === 'b')
    {
        modes.classList.toggle('active');
        background.classList.toggle('active');
    }
});

const display = document.getElementById("displayed");
const inputs = document.getElementById("inputs");
const relay = document.querySelector(".relay");
const int = document.getElementById("int");

function inputct(input)
{
    if(input === '**')
    {
        inputs.value += '^';
    }

    else if(input === '/')
    {
        inputs.value += '÷';
    }

    else if(input === '*')
    {
        inputs.value += '×';
    }

    else
    {
        inputs.value += input;
    }

    int.value += input;
}

function clearinputs()
{
    inputs.value = "";
    int.value = "";
    display.textContent = "";
}

function del()
{
    inputs.value = inputs.value.slice(0, -1);
    int.value = int.value.slice(0, -1);
}

function ans()
{
    if(answer !== 0)
    {
        inputs.value += answer;
        int.value =+ answer;
    } 
}

function calculate()
{
    try
    {
        if(inputs === undefined)
        {
            determine = false;
            display.textContent = ("undefined");
        }

        else if(inputs.value === 'sin' || inputs.value === 'cos' || inputs.value === 'tan' || inputs.value === 'log' || inputs.value === 'sqrt')
        {
            display.textContent = ("undefined");
        }

        else if(inputs.value === 's' || inputs.value === 'i' || inputs.value === 't' || inputs.value === 'g' || inputs.value === 'l' || inputs.value === 'as')
        {
            display.textContent = ("Syntax Error!");
        }

        else if(display === 's')
        {
            display.textContent = ("Syntax Error!");
        }
    
        else
        {
            determine = true;
            let expression = int.value;
            let result = math.evaluate(expression);
            display.textContent = result;
            answer = result;
            console.log(answer);
        }
    }

    catch(error)
    {
        display.textContent = ("Syntax Error!");
    }
    
}

const modes = document.querySelector(".modes");
const background = document.querySelector(".backgroundImg-container")

modes.onclick = function()
{
    modes.classList.toggle('active');
    background.classList.toggle('active');
}

const second = document.querySelector(".scnfunc");
const number2 = document.querySelector(".numbers2-container");
const number = document.querySelector(".numbers-container")

second.onclick = function()
{
    second.classList.toggle('active');
    number2.classList.toggle('active');
    number.classList.toggle('active');
} 

const notebtn = document.querySelector(".notes");
const remindercontainer = document.querySelector(".reminder-container");
const overlay = document.querySelector(".overlay");
const container = document.querySelector(".container");

notebtn.onclick = function()
{
    remindercontainer.classList.toggle('active');
    overlay.classList.toggle('active');
    container.classList.toggle('active');   
}
