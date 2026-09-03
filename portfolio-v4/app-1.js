const stage = document.getElementById('stage');
const world = document.getElementById('world');
const connections = document.getElementById('connections');
const detailPanel = document.getElementById('detailPanel');
const panelContent = document.getElementById('panelContent');
const introOverlay = document.getElementById('introOverlay');
const miniMap = document.getElementById('miniMap');
const miniViewport = document.getElementById('miniViewport');
const focusBreadcrumb = document.getElementById('focusBreadcrumb');
const branchRail = document.getElementById('branchRail');

const WORLD_W = 3000;
const WORLD_H = 2200;
let scale = 0.72;
let tx = 0;
let ty = 0;
let dragging = false;
let dragStart = {x:0,y:0,tx:0,ty:0};
let selectedId = null;

const palettes = {
  root:'#d9872f', validation:'#2f6fbb', clinical:'#3e8ed0', science:'#4f9d69', dev:'#8c63a8', ai:'#e6a33a', human:'#d96b5f', future:'#9a7b35'
};

