
const links = [
  ['root','validation'],['root','clinical'],['root','science'],['root','dev'],['root','ai'],['root','human'],['root','skills'],['root','timeline'],
  ['validation','ennov-alt'],['validation','ennov-stage'],['validation','refs'],['validation','istqb'],
  ['clinical','chu'],['clinical','clinical-concepts'],
  ['science','lome'],['science','bioinfo'],['science','master'],
  ['dev','python-stage'],['dev','holid'],['dev','db'],
  ['ai','core'],['ai','kanban'],['ai','health'],
  ['human','cousin'],['human','unapei'],['human','teaching'],
  ['timeline','future-job']
];

const nodeById = Object.fromEntries(nodes.map(n=>[n.id,n]));

function createNode(n){
  const btn=document.createElement('button');
  btn.className=`node ${n.type||''}`;
  btn.dataset.id=n.id;
  btn.dataset.branch=n.branch;
  btn.style.left=`${n.x}px`;
  btn.style.top=`${n.y}px`;
  btn.style.setProperty('--node-color', palettes[n.branch] || palettes.root);
  const tiltMap={root:0,validation:-1.1,clinical:1.0,science:-1.4,dev:1.2,ai:-.8,human:1.3,future:-.6};
  const jitter=((n.x+n.y)%3-1)*.45;
  btn.style.setProperty('--tilt', `${(tiltMap[n.branch]||0)+jitter}deg`);
  btn.setAttribute('aria-label',`${n.title} — ${n.subtitle||''}`);
  const icon = n.icon==='photo' ? `<img src="assets/tounde-portrait.png" alt="" />` : n.icon;
  btn.innerHTML=`<span class="icon">${icon}</span><span class="copy"><strong>${n.title}</strong><small>${n.subtitle||''}</small></span>`;
  btn.addEventListener('click',(e)=>{ e.stopPropagation(); selectNode(n.id,true); });
  btn.addEventListener('mouseenter',()=>previewBranch(n.branch,n.id));
  btn.addEventListener('mouseleave',clearBranchPreview);
  world.appendChild(btn);
}

function previewBranch(branch,id){
  if(dragging || tourActive) return;
  document.querySelectorAll('.node').forEach(el=>{
    const keep=el.dataset.branch===branch || el.dataset.id==='root' || el.dataset.id===id;
    el.classList.toggle('context-dim',!keep);
  });
  document.querySelectorAll('.connection').forEach(path=>{
    const a=nodeById[path.dataset.a], b=nodeById[path.dataset.b];
    const keep=(a && (a.branch===branch || a.id==='root')) && (b && (b.branch===branch || b.id==='root'));
    path.classList.toggle('context-dim',!keep);
  });
}
function clearBranchPreview(){
  document.querySelectorAll('.node,.connection').forEach(el=>el.classList.remove('context-dim'));
}

function drawConnections(){
  connections.innerHTML='';
  for(const [a,b] of links){
    const A=nodeById[a], B=nodeById[b];
    const midX=(A.x+B.x)/2;
    const path=document.createElementNS('http://www.w3.org/2000/svg','path');
    path.setAttribute('d',`M ${A.x} ${A.y} C ${midX} ${A.y}, ${midX} ${B.y}, ${B.x} ${B.y}`);
    path.setAttribute('class','connection');
    path.dataset.a=a; path.dataset.b=b;
    path.dataset.branch=B.branch || A.branch || 'root';
    path.style.setProperty('--branch-color', palettes[B.branch] || palettes[A.branch] || palettes.root);
    connections.appendChild(path);
  }
}

function createArtLayer(){
  const art=document.createElement('div');
  art.className='art-layer';
  art.setAttribute('aria-hidden','true');
  art.innerHTML=`
    <div class="atlas-sun"></div>
    <div class="atlas-word w-science">RACINES</div>
    <div class="atlas-word w-clinical">DONNÉES</div>
    <div class="atlas-word w-validation">QUALITÉ</div>
    <div class="atlas-word w-dev">CONSTRUIRE</div>
    <div class="atlas-word w-ai">EXPLORER</div>
    <div class="atlas-word w-human">HUMAIN</div>
    <div class="paint-stroke stroke-a"></div>
    <div class="paint-stroke stroke-b"></div>
    <div class="paint-stroke stroke-c"></div>
    <div class="paper-ring ring-a"></div>
    <div class="paper-ring ring-b"></div>

    <div class="territory-scene territory-science" data-territory="science">
      <div class="cell c1"></div><div class="cell c2"></div><div class="cell c3"></div>
      <div class="leaf l1"></div><div class="leaf l2"></div>
      <div class="bio-thread bt1"></div><div class="bio-thread bt2"></div>
      <div class="scene-note"><b>Observer</b><span>le vivant avant de modéliser</span></div>
    </div>

    <div class="territory-scene territory-clinical" data-territory="clinical">
      <div class="ecrf-paper"><b>eCRF</b><i></i><i></i><i></i><span>✓ cohérence</span><span>✓ traçabilité</span></div>
      <div class="clinical-pulse"><i></i><i></i><i></i><i></i><i></i></div>
      <div class="data-dots"><i></i><i></i><i></i><i></i><i></i><i></i></div>
      <div class="scene-note"><b>Structurer</b><span>la donnée pour qu’elle reste fiable</span></div>
    </div>

    <div class="territory-scene territory-validation" data-territory="validation">
      <div class="qa-stamp">VÉRIFIÉ</div>
      <div class="qa-sheet"><span>□ besoin</span><span>□ scénario</span><span>□ exécution</span><span>□ preuve</span><span>□ décision</span></div>
      <div class="qa-rule"></div>
      <div class="scene-note"><b>Démontrer</b><span>ce qui fonctionne, ce qui échoue, pourquoi</span></div>
    </div>

    <div class="territory-scene territory-dev" data-territory="dev">
      <div class="blueprint bp1"></div><div class="blueprint bp2"></div>
      <div class="code-scribble"><span>{ besoin }</span><span>→ comportement</span><span>→ test()</span><span>→ preuve;</span></div>
      <div class="dev-arrow da1"></div><div class="dev-arrow da2"></div>
      <div class="scene-note"><b>Construire</b><span>pour mieux comprendre ce que l’on teste</span></div>
    </div>

    <div class="territory-scene territory-ai" data-territory="ai">
      <div class="atelier-card ac1">PROTOTYPE</div><div class="atelier-card ac2">TEST</div><div class="atelier-card ac3">ITERATE</div>
      <div class="prototype-loop"><i></i><i></i><i></i><i></i></div>
      <div class="maker-line ml1"></div><div class="maker-line ml2"></div>
      <div class="scene-note"><b>Explorer</b><span>sans confondre innovation et preuve</span></div>
    </div>

    <div class="territory-scene territory-human" data-territory="human">
      <div class="human-sun hs1"></div><div class="human-sun hs2"></div><div class="human-sun hs3"></div>
      <div class="hand-line hl1"></div><div class="hand-line hl2"></div>
      <div class="human-words"><span>écouter</span><span>servir</span><span>adapter</span><span>transmettre</span></div>
      <div class="scene-note"><b>Relier</b><span>la technique aux personnes qui l’utilisent</span></div>
    </div>`;
  world.appendChild(art);

  const caption=document.createElement('div');
  caption.className='territory-caption';
  caption.id='territoryCaption';
  caption.innerHTML='<small>ATLAS VIVANT</small><strong>Vue globale</strong><span>Explorez librement les chemins du parcours.</span>';
  stage.appendChild(caption);
}

const territoryCopy={
  root:['Vue globale','Un parcours à lire comme un paysage : les racines, la donnée, la construction, la vérification et l’humain.'],
  science:['Les racines scientifiques','Observer le vivant, raisonner, puis apprendre à structurer l’information.'],
  clinical:['La donnée comme matière','Recueillir, contrôler et rendre la donnée clinique exploitable et traçable.'],
  dev:['L’atelier logiciel','Construire pour comprendre les comportements, les limites et les points à vérifier.'],
  validation:['La preuve et la confiance','Transformer un besoin en vérifications reproductibles, documentées et lisibles.'],
  ai:['Le laboratoire de prototypes','Explorer l’IA et les produits personnels avec une culture de test, de gouvernance et de limites.'],
  human:['L’humain derrière les systèmes','Service, écoute, adaptation et transmission : les qualités qui donnent du sens à la technique.'],
  future:['Le prochain chapitre','Faire converger ces acquis vers un premier poste puis des responsabilités croissantes.']
};

function setTerritoryTheme(branch='root'){
  const territory=territoryCopy[branch]?branch:'root';
  stage.dataset.territory=territory;
  document.body.dataset.territory=territory;
  document.querySelectorAll('.territory-scene').forEach(el=>el.classList.toggle('active',el.dataset.territory===territory));
  const cap=document.getElementById('territoryCaption');
  if(cap){
    const [title,text]=territoryCopy[territory];
    cap.classList.remove('visible');
    requestAnimationFrame(()=>{
      cap.innerHTML=`<small>ATLAS VIVANT · ${territory==='root'?'ENSEMBLE':branchLabels[territory]||'PARCOURS'}</small><strong>${title}</strong><span>${text}</span>`;
      cap.classList.add('visible');
    });
  }
}

const territoryCenters={science:[1020,1385],clinical:[1025,760],validation:[1950,760],dev:[1975,1385],ai:[2450,1090],human:[1500,1740],future:[1500,2050]};
let lastAutoTerritory='root';
function detectTerritoryFromCamera(){
  if(detailPanel.classList.contains('open') || tourActive || !dragging) return;
  const rect=stage.getBoundingClientRect();
  const cx=(rect.width/2-tx)/scale, cy=(rect.height/2-ty)/scale;
  let nearest='root',best=430;
  for(const [name,[x,y]] of Object.entries(territoryCenters)){
    const d=Math.hypot(cx-x,cy-y);
    if(d<best){best=d;nearest=name;}
  }
  if(nearest!==lastAutoTerritory){lastAutoTerritory=nearest;setTerritoryTheme(nearest);}
}

function createMiniMap(){
  miniMap.innerHTML='';
  nodes.forEach(n=>{
    const d=document.createElement('i');
    d.className='mini-dot';
    d.style.left=`${n.x/WORLD_W*100}%`; d.style.top=`${n.y/WORLD_H*100}%`;
    d.style.setProperty('--dot-color', palettes[n.branch]||palettes.root);
    miniMap.appendChild(d);
  });
}

function clampTransform(){
  const rect=stage.getBoundingClientRect();
  const minVisible=140;
  const minX=rect.width - WORLD_W*scale - minVisible;
  const minY=rect.height - WORLD_H*scale - minVisible;
  tx=Math.min(minVisible, Math.max(minX, tx));
  ty=Math.min(minVisible, Math.max(minY, ty));
}

function applyTransform(){
  clampTransform();
  const t=`translate(${tx}px, ${ty}px) scale(${scale})`;
  world.style.transform=t; connections.style.transform=t;
  updateMiniViewport();
  detectTerritoryFromCamera();
}

function fitHome(animated=false){
  const rect=stage.getBoundingClientRect();
  scale=Math.min(0.78, Math.max(0.44, Math.min(rect.width/1900, rect.height/1350)));
  const root=nodeById.root;
  tx=rect.width/2-root.x*scale;
  ty=rect.height/2-root.y*scale;
  setTerritoryTheme('root');
  if(animated) animateTransform(); else applyTransform();
}

function animateTransform(){
  world.style.transition='transform .7s cubic-bezier(.2,.8,.2,1)';
  connections.style.transition='transform .7s cubic-bezier(.2,.8,.2,1)';
  applyTransform();
  setTimeout(()=>{world.style.transition='';connections.style.transition='';},730);
}

function zoomAt(clientX,clientY,factor){
  const rect=stage.getBoundingClientRect();
  const sx=clientX-rect.left, sy=clientY-rect.top;
  const wx=(sx-tx)/scale, wy=(sy-ty)/scale;
  const next=Math.max(.34, Math.min(1.45, scale*factor));
  tx=sx-wx*next; ty=sy-wy*next; scale=next; applyTransform();
}

function zoomToNode(id, zoom=1.02){
  const n=nodeById[id]; if(!n)return;
  const rect=stage.getBoundingClientRect();
  scale=Math.max(.55,Math.min(1.25,zoom));
  const panelOffset=detailPanel.classList.contains('open') && rect.width>900 ? -210 : 0;
  tx=rect.width/2 + panelOffset - n.x*scale;
  ty=rect.height/2 - n.y*scale;
  animateTransform();
}

function statusFor(n){
  const map={
    'core':['En développement','working'],
    'kanban':['Opérationnel · consolidation','working'],
    'health':['Prototype V1','prototype'],
    'istqb':['En préparation','learning'],
    'master':['Master 2 en cours','learning'],
    'future-job':['Objectif professionnel','future']
  };
  return map[n.id]||null;
}

