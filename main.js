const api = {
    key: "7e3f21edee540e6110af347b55eb1ab2",
    base: "https://api.openweathermap.org/data/2.5/"
  }

const searchBox = document.querySelector('.search-box');
searchBox.addEventListener('keypress', setQuery);

function setQuery(evt) {
    
    if(evt.keyCode== 13) {
        getResults(searchBox.value);        
    }
};

function getResults(city) {
    console.log(`${api.base}`);
    console.log(`${api.key}`);

    fetch(`${api.base}weather?q=${city}&units=metric&appid=${api.key}`)
    .then(weather => {

        return weather.json();
    }).then(response => {
        console.log(response);
        displayResults(response);
    });
};

function displayResults(weatherResult) {

    let city  = document.querySelector('.location .city');
    city.innerText = `${weatherResult.name}, ${weatherResult.sys.country}`;
    let now = new Date();
    let date  = document.querySelector('.location .date');
    date.innerText  = dateBuilder(now);

    let temp = document.querySelector('.current .temp');
    temp.innerHtml =`${Math.round(weatherResult.main.temp)}<span> °c</span>`;


    let weather = document.querySelector('.current .weather');
    weather.innerText = weatherResult.weather[0].main;

    let highLow = document.querySelector('.hi-low')
    highLow.innerText = `${Math.round(weatherResult.main.temp_min)} °c : ${Math.round(weatherResult.main.temp_max)} °c`;

}

function dateBuilder(dt) {
    let mon = ['jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'aug', 'sep', 'oct', 'nov', 'dec'];
    let days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursdy','Friday', 'Saturday']; 
    let day,date,month,year;
    day =days[dt.getDay()];
    month = mon[dt.getMonth()];
    date = dt.getDate();
    year = dt.getFullYear();
    return `${day} ${month} ${date} ${year}`;
}