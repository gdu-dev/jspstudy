/**
 * 
 */

const getDateTime = ()=>{
  const type = document.getElementById('type');
  if(type.value === 'date'){
    location.href = '/mvc/getDate.do';
  } else if(type.value === 'time'){
    location.href = '/mvc/getTime.do';
  } else if(type.value === 'datetime'){
    location.href = '/mvc/getDateTime.do';
  }
}

document.getElementById('btn').addEventListener('click', getDateTime);