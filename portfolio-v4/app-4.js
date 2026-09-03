function panelVisual(n){
  if(['validation','ennov-alt','ennov-stage'].includes(n.id)) return `
    <div class="micro-demo trace-demo" aria-label="Illustration de traçabilité de test">
      <div class="demo-label">ILLUSTRATION DE DÉMARCHE</div>
      <div class="trace-flow"><span>Besoin</span><i>→</i><span>Cas de test</span><i>→</i><span class="trace-run">Exécution</span><i>→</i><span class="trace-pass">Preuve</span></div>
      <div class="trace-meta"><b>Traçabilité</b><small>Besoin → vérification → résultat → élément exploitable</small></div>
    </div>`;
  if(['clinical','chu','clinical-concepts'].includes(n.id)) return `
    <div class="micro-demo ecrf-demo" aria-label="Illustration de flux eCRF">
      <div class="demo-label">DONNÉE CLINIQUE · FLUX SIMPLIFIÉ</div>
      <div class="ecrf-form"><span><i>01</i>Donnée recueillie</span><span><i>02</i>Contrôle de cohérence</span><span class="ok"><i>03</i>Traçabilité / QC</span></div>
      <div class="ecrf-wave"><b></b><b></b><b></b><b></b><b></b><b></b></div>
    </div>`;
  if(['science','lome','bioinfo','master'].includes(n.id)) return `
    <div class="micro-demo science-demo" aria-label="Illustration des fondations scientifiques">
      <div class="demo-label">LES RACINES</div>
      <div class="dna"><i></i><i></i><i></i><i></i><i></i><i></i><i></i></div>
      <div class="science-steps"><span>Vivant</span><b>→</b><span>Information</span><b>→</b><span>Système</span></div>
    </div>`;
  if(['dev','python-stage','holid','db'].includes(n.id)) return `
    <div class="micro-demo code-demo" aria-label="Illustration développement et vérification">
      <div class="demo-label">COMPRENDRE CE QUE L'ON TESTE</div>
      <pre><code><em>01</em> besoin   <b>→</b> spécification\n<em>02</em> code     <b>→</b> comportement\n<em>03</em> test     <b>→</b> observation\n<em>04</em> preuve   <b>→</b> décision</code></pre>
      <div class="code-status"><span></span> logique vérifiable</div>
    </div>`;
  if(n.id==='core') return `
    <div class="micro-demo core-demo" aria-label="Mini démonstration conceptuelle ALOGBO CORE">
      <div class="demo-label">MINI-DÉMO CONCEPTUELLE · ALOGBO CORE</div>
      <div class="agent-pipeline"><span class="active">Comprendre</span><i>→</i><span>Planifier</span><i>→</i><span>Agir</span><i>→</i><span>Vérifier</span></div>
      <div class="terminal"><p><b>mission&gt;</b> vérifier une modification</p><p class="terminal-line">analyse du contexte…</p><p class="terminal-line">preuves requises…</p><p class="terminal-line ok">✓ validation humaine requise</p></div>
      <small class="demo-disclaimer">Illustration du principe — pas une capture d’un système validé.</small>
    </div>`;
  if(n.id==='kanban') return `
    <div class="micro-demo kanban-demo" aria-label="Mini démonstration conceptuelle ATAC Kanban">
      <div class="demo-label">MINI-DÉMO CONCEPTUELLE · ATAC KANBAN</div>
      <div class="kanban-board">
        <div><b>À faire</b><span>Cas de test API</span><span>GED · pièce jointe</span></div>
        <div><b>En cours</b><span class="moving-card">Migration SQL</span></div>
        <div><b>Vérifié</b><span class="done-card">Rapport KPI ✓</span></div>
      </div>
      <div class="kanban-footer"><span>GED</span><span>TESTS</span><span>KPI</span><span>CI/CD</span></div>
      <small class="demo-disclaimer">Visualisation de fonctionnalités, pas une capture de l’interface de production.</small>
    </div>`;
  if(n.id==='health') return `
    <div class="micro-demo health-demo" aria-label="Mini démonstration conceptuelle plateforme e-santé">
      <div class="demo-label">ARCHITECTURE MULTI-ORGANISATION · PROTOTYPE</div>
      <div class="health-network">
        <span class="hub">Superadmin</span>
        <span class="hospital h1">Centre A<small>Services · GED</small></span>
        <span class="hospital h2">Centre B<small>Rôles · Formulaires</small></span>
        <span class="hospital h3">Centre C<small>Traçabilité · KPI</small></span>
        <svg viewBox="0 0 400 150" aria-hidden="true"><path d="M200 34 L84 104 M200 34 L200 114 M200 34 L316 104"/></svg>
      </div>
      <div class="prototype-warning">Prototype — aucune utilisation hospitalière en production ni conformité/certification revendiquée.</div>
    </div>`;
  if(n.id==='skills') return `
    <div class="micro-demo skill-demo" aria-label="Constellation de compétences">
      <div class="demo-label">SKILL GALAXY</div>
      <div class="skill-orbit"><span class="skill-core">T.A.</span><i>Tests & QA</i><i>Data clinique</i><i>Développement</i><i>Bases de données</i><i>Méthodes</i><i>Référentiels</i><i>IA</i></div>
      <small class="demo-disclaimer">Les outils sont présentés selon leur contexte d’usage réel.</small>
    </div>`;
  if(n.id==='timeline' || n.id==='future-job') return `
    <div class="micro-demo timeline-demo" aria-label="Trajectoire professionnelle">
      <div class="demo-label">TRAJECTOIRE</div>
      <div class="timeline-track"><span><b>2018</b>Sciences</span><span><b>2023</b>Data clinique</span><span><b>2025</b>Validation</span><span class="now"><b>2026</b>CDI visé</span><span><b>2031</b>Responsabilités</span></div>
    </div>`;
  if(n.id==='human' || ['cousin','unapei','teaching'].includes(n.id)) return `
    <div class="micro-demo human-demo" aria-label="Compétences humaines transférables">
      <div class="demo-label">L'HUMAIN DERRIÈRE LES SYSTÈMES</div>
      <div class="human-values"><span>Rigueur</span><span>Service</span><span>Écoute</span><span>Adaptation</span><span>Résilience</span><span>Transmission</span></div>
    </div>`;
  if(n.id==='root') return `
    <div class="micro-demo root-demo" aria-label="Fil narratif du parcours">
      <div class="demo-label">FIL DIRECTEUR</div>
      <div class="root-journey"><span>Vivant</span><i>→</i><span>Données</span><i>→</i><span>Logiciels</span><i>→</i><span class="active">Validation</span><i>→</i><span>Systèmes fiables</span></div>
    </div>`;
  return '';
}

function activatePanelDemo(n){
  const panel=detailPanel;
  panel.querySelectorAll('.terminal-line').forEach((el,i)=>setTimeout(()=>el.classList.add('visible'),300+i*420));
  const stages=panel.querySelectorAll('.agent-pipeline span');
  stages.forEach((el,i)=>setTimeout(()=>{stages.forEach(x=>x.classList.remove('active'));el.classList.add('active')},450+i*620));
}

function renderPanel(n){
  const c=palettes[n.branch]||palettes.root;
  const status=statusFor(n);
  panelContent.style.setProperty('--node-color',c);
  panelContent.innerHTML=`
    <div class="panel-kicker">${n.kicker||'PARCOURS'}</div>
    <h2 class="panel-title">${n.title}</h2>
    ${status?`<div class="status-line"><span class="status-dot ${status[1]}"></span><b>${status[0]}</b></div>`:''}
    <p class="panel-lead">${n.lead||''}</p>
    ${panelVisual(n)}
    <div class="panel-chips">${(n.chips||[]).map(c=>`<span class="panel-chip">${c}</span>`).join('')}</div>
    <div class="panel-section"><h4>Ce que cela raconte</h4><ul class="panel-list">${(n.bullets||[]).map(b=>`<li>${b}</li>`).join('')}</ul></div>
    <div class="evidence-card"><strong>Point de lecture</strong><p>${n.evidence||''}</p></div>
    <div class="panel-section panel-tools"><h4>Navigation</h4><div class="panel-chips"><button class="secondary compact" data-share-node="${n.id}">Partager ce nœud</button>${n.id!=='root'?`<button class="secondary compact" data-back-root>Vue globale</button>`:''}${n.id==='root'?`<button class="secondary compact" onclick="openRecruiter()">Mode recruteur</button><a class="secondary compact" href="mailto:alogbotounde@gmail.com?subject=Demande%20du%20book%20professionnel" target="_blank" rel="noopener">Book complet</a><a class="secondary compact" href="mailto:alogbotounde@gmail.com">Contact</a>`:''}</div></div>
  `;
  const share=panelContent.querySelector('[data-share-node]');
  if(share) share.onclick=()=>shareNode(n.id,share);
  const back=panelContent.querySelector('[data-back-root]');
  if(back) back.onclick=()=>{detailPanel.classList.remove('open');selectNode('root',false);fitHome(true)};
  activatePanelDemo(n);
}

function updateActiveConnections(id){
  document.querySelectorAll('.connection').forEach(p=>{
    p.classList.toggle('active',p.dataset.a===id||p.dataset.b===id);
  });
}

function selectNode(id, open=true){
  selectedId=id; clearBranchPreview();
  document.querySelectorAll('.node').forEach(el=>el.classList.toggle('selected',el.dataset.id===id));
  updateActiveConnections(id);
  const n=nodeById[id];
  updateBreadcrumb(n);
  updateBranchRail(n);
  setTerritoryTheme(n.id==='root'?'root':n.branch);
  if(open){ renderPanel(n); detailPanel.classList.add('open'); updateHash(id); }
  zoomToNode(id,n.type==='root'?0.92:(n.type==='micro'?1.1:1.02));
}

const branchLabels={root:'Vue globale',validation:'Validation & Qualité',clinical:'Data clinique',science:'Sciences du vivant',dev:'Développement logiciel',ai:'IA & Produits',human:'Expériences humaines',future:'Trajectoire'};
function updateBreadcrumb(n){
  if(!focusBreadcrumb)return;
  if(n.id==='root') focusBreadcrumb.innerHTML='<span>Vue globale</span>';
  else focusBreadcrumb.innerHTML=`<span>Parcours</span><i>›</i><span>${branchLabels[n.branch]||'Exploration'}</span>${n.type!=='branch'?`<i>›</i><b>${n.title}</b>`:''}`;
}
function updateBranchRail(n){
  if(!branchRail)return;
  branchRail.querySelectorAll('button').forEach(b=>b.classList.toggle('active',b.dataset.jump===n.id || b.dataset.jump===n.branch));
}
function updateHash(id){
  const url=new URL(location.href); url.hash=`node=${encodeURIComponent(id)}`;
  history.replaceState(null,'',url);
}
function shareNode(id,button){
  const url=new URL(location.href); url.hash=`node=${encodeURIComponent(id)}`;
  const text=url.toString();
  if(navigator.share){navigator.share({title:`Toundé ALOGBO — ${nodeById[id].title}`,url:text}).catch(()=>{});return;}
  navigator.clipboard?.writeText(text).then(()=>{const old=button.textContent;button.textContent='Lien copié ✓';setTimeout(()=>button.textContent=old,1500)}).catch(()=>{});
}
branchRail?.querySelectorAll('button').forEach(b=>b.addEventListener('click',()=>selectNode(b.dataset.jump,true)));

function closePanel(){detailPanel.classList.remove('open'); setTimeout(()=>{ if(selectedId) zoomToNode(selectedId, nodeById[selectedId].type==='root'?.92:.9);},60);}

stage.addEventListener('pointerdown',e=>{
  if(e.target.closest('.node')||e.target.closest('.zoom-controls')||e.target.closest('.tour-pill'))return;
  dragging=true; stage.classList.add('dragging'); stage.setPointerCapture(e.pointerId);
  dragStart={x:e.clientX,y:e.clientY,tx,ty};
});
stage.addEventListener('pointermove',e=>{ if(!dragging)return; tx=dragStart.tx+(e.clientX-dragStart.x); ty=dragStart.ty+(e.clientY-dragStart.y); applyTransform(); });
stage.addEventListener('pointerup',e=>{ dragging=false; stage.classList.remove('dragging'); try{stage.releasePointerCapture(e.pointerId)}catch{} });
stage.addEventListener('wheel',e=>{ e.preventDefault(); zoomAt(e.clientX,e.clientY,e.deltaY<0?1.09:.92); },{passive:false});

function updateMiniViewport(){
  const rect=stage.getBoundingClientRect();
  const innerRect=miniMap.getBoundingClientRect();
  if(!innerRect.width)return;
  const wx0=(-tx/scale), wy0=(-ty/scale), ww=rect.width/scale, wh=rect.height/scale;
  const left=8+(wx0/WORLD_W)*(154-16);
  const top=24+(wy0/WORLD_H)*(112-31);
  const w=(ww/WORLD_W)*(154-16), h=(wh/WORLD_H)*(112-31);
  miniViewport.style.left=`${left}px`; miniViewport.style.top=`${top}px`;
  miniViewport.style.width=`${Math.max(12,Math.min(138,w))}px`; miniViewport.style.height=`${Math.max(10,Math.min(81,h))}px`;
}

document.getElementById('zoomIn').onclick=()=>zoomAt(stage.clientWidth/2,stage.clientHeight/2,1.16);
document.getElementById('zoomOut').onclick=()=>zoomAt(stage.clientWidth/2,stage.clientHeight/2,.86);
document.getElementById('centerBtn').onclick=()=>fitHome(true);
document.getElementById('homeBtn').onclick=()=>{detailPanel.classList.remove('open');selectNode('root',false);fitHome(true)};
document.getElementById('panelClose').onclick=closePanel;

function dismissIntro(startTour=false){
  introOverlay.classList.add('hidden');
  localStorage.setItem('tounde-intro-seen','1');
  setTimeout(()=>{ if(startTour) startGuidedTour(); else {selectNode('root',false);fitHome(true);} },500);
}
document.getElementById('freeExploreBtn').onclick=()=>dismissIntro(false);
document.getElementById('guidedStartBtn').onclick=()=>dismissIntro(true);

// Search
const searchOverlay=document.getElementById('searchOverlay');
const searchInput=document.getElementById('searchInput');
const searchResults=document.getElementById('searchResults');
function openSearch(){searchOverlay.classList.add('open'); renderSearch(''); setTimeout(()=>searchInput.focus(),80);}
function closeSearch(){searchOverlay.classList.remove('open');}
function renderSearch(q){
  const s=q.trim().toLowerCase();
  const results=nodes.filter(n=>!s || [n.title,n.subtitle,n.lead,...(n.chips||[]),...(n.bullets||[])].join(' ').toLowerCase().includes(s)).slice(0,12);
  searchResults.innerHTML=results.map(n=>`<button class="search-result" data-id="${n.id}"><strong>${n.title}</strong><span>${n.subtitle||n.kicker||''}</span></button>`).join('') || `<div style="color:#7f94a2;padding:14px">Aucun résultat.</div>`;
  searchResults.querySelectorAll('.search-result').forEach(b=>b.onclick=()=>{closeSearch();selectNode(b.dataset.id,true)});
}
document.getElementById('searchBtn').onclick=openSearch;
document.getElementById('searchClose').onclick=closeSearch;
searchOverlay.addEventListener('click',e=>{if(e.target===searchOverlay)closeSearch()});
searchInput.addEventListener('input',e=>renderSearch(e.target.value));
document.addEventListener('keydown',e=>{
  if((e.ctrlKey||e.metaKey)&&e.key.toLowerCase()==='k'){e.preventDefault();openSearch();}
  if(e.key==='Escape'){closeSearch();closePanel();closeRecruiter(); if(tourActive) exitTour();}
});

// Recruiter
const recruiterOverlay=document.getElementById('recruiterOverlay');
function openRecruiter(){recruiterOverlay.classList.add('open');}
function closeRecruiter(){recruiterOverlay.classList.remove('open');}
window.openRecruiter=openRecruiter;
document.getElementById('recruiterBtn').onclick=openRecruiter;
document.getElementById('recruiterClose').onclick=closeRecruiter;
recruiterOverlay.addEventListener('click',e=>{if(e.target===recruiterOverlay)closeRecruiter()});

// Guided tour
const tourOverlay=document.getElementById('tourOverlay');
const tourSequence=[
  {id:'root',title:'Une trajectoire construite',text:'Mon parcours part des sciences du vivant et converge vers la qualité des systèmes numériques de santé.'},
  {id:'science',title:'1. Comprendre le vivant',text:'Biologie, physiologie, bio-informatique : les racines scientifiques de mon raisonnement.'},
  {id:'chu',title:'2. Comprendre la donnée clinique',text:'Au CHU de Poitiers, je découvre les eCRF, la qualité des données et les outils de data management clinique.'},
  {id:'dev',title:'3. Comprendre le logiciel',text:'Le développement Python puis Symfony me donne une culture technique utile pour mieux tester et dialoguer avec les équipes.'},
  {id:'ennov-alt',title:'4. Valider en environnement EDC',text:'Chez Ennov, je transforme des besoins en scénarios vérifiables : tests, anomalies, régression, API, migration et documentation.'},
  {id:'ai',title:'5. Construire avec une culture de vérification',text:'ALOGBO CORE, ATAC Kanban et la plateforme e-santé prolongent le même fil rouge : agir, vérifier, documenter et maîtriser les limites.'},
  {id:'future-job',title:'6. Le prochain chapitre',text:'Je vise un premier CDI en validation, QA, VSI ou data clinique, dans un environnement structuré et exigeant.'}
];
let tourIndex=0, tourTimer=null, tourActive=false, tourPaused=false;
function updateTour(){
  const step=tourSequence[tourIndex];
  document.getElementById('tourStep').textContent=`ÉTAPE ${tourIndex+1} / ${tourSequence.length}`;
  document.getElementById('tourTitle').textContent=step.title;
  document.getElementById('tourText').textContent=step.text;
  document.getElementById('tourProgress').style.width=`${(tourIndex+1)/tourSequence.length*100}%`;
  selectNode(step.id,false);
  if(!tourPaused){ clearTimeout(tourTimer); tourTimer=setTimeout(nextTour,12500); }
}
function startGuidedTour(){
  tourActive=true;tourPaused=false;tourIndex=0;detailPanel.classList.remove('open');tourOverlay.classList.add('open');updateTour();
}
function nextTour(){if(!tourActive)return; if(tourIndex>=tourSequence.length-1){exitTour();openRecruiter();return;} tourIndex++;updateTour();}
function prevTour(){if(tourIndex>0){tourIndex--;updateTour();}}
function exitTour(){tourActive=false;clearTimeout(tourTimer);tourOverlay.classList.remove('open');fitHome(true);}
document.getElementById('tourBtn').onclick=startGuidedTour;
document.getElementById('tourNext').onclick=nextTour;
document.getElementById('tourPrev').onclick=prevTour;
document.getElementById('tourExit').onclick=exitTour;
