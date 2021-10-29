
var coursesApi = 'http://localhost:8081/api/vi/Parents'

var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

function start() {
  getAllParents(loadParents);

  handleCreateParents();
  findById();
  updateParentById();
  deleteParent();
  getElm('maPH', makeid(9));
}

// chay start dau tien
start();

// Functions

function getAllParents(callback){
  fetch(coursesApi+'/getallParents').then(function(response){
    return response.json();
  }).then(callback);
}


function loadParents(courses){
  var listCourseBlock = document.querySelector('#list-courses')
  var htmls = courses.map(function(course){
    return `
          <tr>
            <th>${course.maPH}</th>
            <td>${course.tenPH}</td>
            <td>${course.sdt}</td>
            <td>${course.quanHe}</td>
            <td>${course.ghiChu}</td>
            <td><button id="edit" onclick="edit('${course.maPH}');">edit</button></td>
          </tr>
    `;
  });
  listCourseBlock.innerHTML = htmls.join('');
}

function handleCreateParents(){
    var createParents = document.querySelector('#create');

    createParents.onclick = function(){
      var maPH = document.querySelector('input[name="maPH"]').value;
      var tenPH = document.querySelector('input[name="tenPH"]').value;
      var sdt = document.querySelector('input[name="sdt"]').value;
      var quanHe = document.querySelector('input[name="quanHe"]').value;
      var ghiChu = document.querySelector('input[name="ghiChu"]').value;
      
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");

      var raw = JSON.stringify({
        tenPH: tenPH,
        maPH: maPH,
        sdt: sdt,
        quanHe: quanHe,
        ghiChu: ghiChu
      });

      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
      };

      fetch(coursesApi+"/insert", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .then(getAllParents())
        .catch(error => console.log('error', error));
      // createCourse(formData);
    }
}

function findById(){
  var findParentById = document.querySelector('#findByID');

  findParentById.onclick = function(){
    var maPH = document.querySelector('input[name="maPH"]').value;
    var requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };
    
    fetch(coursesApi+'/MAPH/'+maPH, requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
    loadParents();
  }
}


function deleteParent(){
  var deleteParentById = document.querySelector('#delete');

  deleteParentById.onclick = function(){
    var maPH = document.querySelector('input[name="maPH"]').value;
    var requestOptions = {
      method: 'DELETE',
      redirect: 'follow'
    };
    
    fetch(coursesApi+"/"+maPH, requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
  }
}
function getElm(el, value){
  document.getElementById(el).value = `${value}`;
}

function makeid(length) {
  var result           = '';
  var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
  var charactersLength = characters.length;
  for ( var i = 0; i < length; i++ ) {
    result += characters.charAt(Math.floor(Math.random() * 
charactersLength));
 }
 return result;
}

function edit(maPH){
  getElm('maPH', maPH);
  
}

function updateParentById(){
  var updateParentById = document.querySelector('#update');

  updateParentById.onclick = function(){
    var maPH = document.querySelector('input[name="maPH"]').value;
    if (maPH){
    
    var tenPH = document.querySelector('input[name="tenPH"]').value;
    var sdt = document.querySelector('input[name="sdt"]').value;
    var quanHe = document.querySelector('input[name="quanHe"]').value;
    var ghiChu = document.querySelector('input[name="ghiChu"]').value;

      var raw = JSON.stringify({
        tenPH: tenPH,
        sdt: sdt,
        quanHe: quanHe,
        ghiChu: ghiChu
      });

      var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
      };

      fetch(coursesApi+"/"+maPH, requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
      getAllParents(loadParents);
      }else{
        alert('Vui long chon edit')
      }
      
  }
}
