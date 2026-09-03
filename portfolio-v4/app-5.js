document.getElementById('tourPause').onclick=()=>{tourPaused=!tourPaused;document.getElementById('tourPause').textContent=tourPaused?'Reprendre':'Pause'; if(tourPaused)clearTimeout(tourTimer);else updateTour();};

function nodeFromHash(){
  const match=location.hash.match(/node=([^&]+)/); return match?decodeURIComponent(match[1]):null;
}
window.addEventListener('hashchange',()=>{const id=nodeFromHash();if(id&&nodeById[id])selectNode(id,true)});

// Init
createArtLayer(); setTerritoryTheme('root'); nodes.forEach(createNode); drawConnections(); createMiniMap();
window.addEventListener('resize',()=>fitHome(false));
setTimeout(()=>{
  const deep=nodeFromHash();
  if(deep && nodeById[deep]){introOverlay.classList.add('hidden');selectNode(deep,true);} else fitHome(false);
},30);
if(localStorage.getItem('tounde-intro-seen')==='1'){
  // Keep the intro on repeat visits for LinkedIn visitors, but make it faster to dismiss by clicking the backdrop.
  introOverlay.addEventListener('dblclick',()=>dismissIntro(false));
}
