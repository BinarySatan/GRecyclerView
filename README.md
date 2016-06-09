<!DOCTYPE html>
<!-- saved from url=(0021)http://mahua.jser.me/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title> MaHua 在线markdown编辑器</title>
    <meta name="keywords" content="online markdown editor,markdown编辑器,在线编辑markdown">
    <meta name="description" content="MaHua是一个在线编辑markdown的工具">
    <meta name="COPYRIGHT" content="版权所有2012,http://MaHua.jser.me/">
    <link href="./README_files/mahua.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="http://mahua.jser.me/favicon.png" type="image/vnd.microsoft.icon">
<style id="ace_editor">.ace_editor {
    position: absolute;
    overflow: hidden;
    font-family: 'Monaco', 'Menlo', 'Ubuntu Mono', 'Droid Sans Mono', 'Consolas', monospace;
    font-size: 12px;
}

.ace_scroller {
    position: absolute;
    overflow: hidden;
}

.ace_content {
    position: absolute;
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    cursor: text;
}

.ace_gutter {
    position: absolute;
    overflow : hidden;
    height: 100%;
    width: auto;
    cursor: default;
    z-index: 4;
}

.ace_gutter_active_line {
    position: absolute;
    left: 0;
    right: 0;
}

.ace_scroller.horscroll {
    box-shadow: 17px 0 16px -16px rgba(0, 0, 0, 0.4) inset;
}

.ace_gutter-cell {
    padding-left: 19px;
    padding-right: 6px;
    background-repeat: no-repeat;
}

.ace_gutter-cell.ace_error {
    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBNYWNpbnRvc2giIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QUM2OEZDQTQ4RTU0MTFFMUEzM0VFRTM2RUY1M0RBMjYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QUM2OEZDQTU4RTU0MTFFMUEzM0VFRTM2RUY1M0RBMjYiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpBQzY4RkNBMjhFNTQxMUUxQTMzRUVFMzZFRjUzREEyNiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpBQzY4RkNBMzhFNTQxMUUxQTMzRUVFMzZFRjUzREEyNiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PkgXxbAAAAJbSURBVHjapFNNaBNBFH4zs5vdZLP5sQmNpT82QY209heh1ioWisaDRcSKF0WKJ0GQnrzrxasHsR6EnlrwD0TagxJabaVEpFYxLWlLSS822tr87m66ccfd2GKyVhA6MMybgfe97/vmPUQphd0sZjto9XIn9OOsvlu2nkqRzVU+6vvlzPf8W6bk8dxQ0NPbxAALgCgg2JkaQuhzQau/El0zbmUA7U0Es8v2CiYmKQJHGO1QICCLoqilMhkmurDAyapKgqItezi/USRdJqEYY4D5jCy03ht2yMkkvL91jTTX10qzyyu2hruPRN7jgbH+EOsXcMLgYiThEgAMhABW85oqy1DXdRIdvP1AHJ2acQXvDIrVHcdQNrEKNYSVMSZGMjEzIIAwDXIo+6G/FxcGnzkC3T2oMhLjre49sBB+RRcHLqdafK6sYdE/GGBwU1VpFNj0aN8pJbe+BkZyevUrvLl6Xmm0W9IuTc0DxrDNAJd5oEvI/KRsNC3bQyNjPO9yQ1YHcfj2QvfQc/5TUhJTBc2iM0U7AWDQtc1nJHvD/cfO2s7jaGkiTEfa/Ep8coLu7zmNmh8+dc5lZDuUeFAGUNA/OY6JVaypQ0vjr7XYjUvJM37vt+j1vuTK5DgVfVUoTjVe+y3/LxMxY2GgU+CSLy4cpfsYorRXuXIOi0Vt40h67uZFTdIo6nLaZcwUJWAzwNS0tBnqqKzQDnjdG/iPyZxo46HaKUpbvYkj8qYRTZsBhge+JHhZyh0x9b95JqjVJkT084kZIPwu/mPWqPgfQ5jXh2+92Ay7HedfAgwA6KDWafb4w3cAAAAASUVORK5CYII=");
    background-repeat: no-repeat;
    background-position: 2px center;
}

.ace_gutter-cell.ace_warning {
    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBNYWNpbnRvc2giIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QUM2OEZDQTg4RTU0MTFFMUEzM0VFRTM2RUY1M0RBMjYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QUM2OEZDQTk4RTU0MTFFMUEzM0VFRTM2RUY1M0RBMjYiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpBQzY4RkNBNjhFNTQxMUUxQTMzRUVFMzZFRjUzREEyNiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpBQzY4RkNBNzhFNTQxMUUxQTMzRUVFMzZFRjUzREEyNiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pgd7PfIAAAGmSURBVHjaYvr//z8DJZiJgUIANoCRkREb9gLiSVAaQx4OQM7AAkwd7XU2/v++/rOttdYGEB9dASEvOMydGKfH8Gv/p4XTkvRBfLxeQAP+1cUhXopyvzhP7P/IoSj7g7Mw09cNKO6J1QQ0L4gICPIv/veg/8W+JdFvQNLHVsW9/nmn9zk7B+cCkDwhL7gt6knSZnx9/LuCEOcvkIAMP+cvto9nfqyZmmUAksfnBUtbM60gX/3/kgyv3/xSFOL5DZT+L8vP+Yfh5cvfPvp/xUHyQHXGyAYwgpwBjZYFT3Y1OEl/OfCH4ffv3wzc4iwMvNIsDJ+f/mH4+vIPAxsb631WW0Yln6ZpQLXdMK/DXGDflh+sIv37EivD5x//Gb7+YWT4y86sl7BCCkSD+Z++/1dkvsFRl+HnD1Rvje4F8whjMXmGj58YGf5zsDMwcnAwfPvKcml62DsQDeaDxN+/Y0qwlpEHqrdB94IRNIDUgfgfKJChGK4OikEW3gTiXUB950ASLFAF54AC94A0G9QAfOnmF9DCDzABFqS08IHYDIScdijOjQABBgC+/9awBH96jwAAAABJRU5ErkJggg==");
    background-position: 2px center;
}

.ace_gutter-cell.ace_info {
    background-image: url("data:image/gif;base64,R0lGODlhEAAQAMQAAAAAAEFBQVJSUl5eXmRkZGtra39/f4WFhYmJiZGRkaampry8vMPDw8zMzNXV1dzc3OTk5Orq6vDw8P///wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACH5BAkAABQALAAAAAAQABAAAAUuICWOZGmeaBml5XGwFCQSBGyXRSAwtqQIiRuiwIM5BoYVbEFIyGCQoeJGrVptIQA7");
    background-position: 2px center;
}
.ace_dark .ace_gutter-cell.ace_info {
    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpGRTk5MTVGREIxNDkxMUUxOTc5Q0FFREQyMTNGMjBFQyIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpGRTk5MTVGRUIxNDkxMUUxOTc5Q0FFREQyMTNGMjBFQyI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkZFOTkxNUZCQjE0OTExRTE5NzlDQUVERDIxM0YyMEVDIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkZFOTkxNUZDQjE0OTExRTE5NzlDQUVERDIxM0YyMEVDIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+SIDkjAAAAJ1JREFUeNpi/P//PwMlgImBQkB7A6qrq/+DMC55FkIGKCoq4pVnpFkgTp069f/+/fv/r1u37r+tre1/kg0A+ptn9uzZYLaRkRHpLvjw4cNXWVlZhufPnzOcO3eOdAO0tbVPAjHDmzdvGA4fPsxIsgGSkpJmv379Ynj37h2DjIyMCMkG3LhxQ/T27dsMampqDHZ2dq/pH41DxwCAAAMAFdc68dUsFZgAAAAASUVORK5CYII=");
}

.ace_editor .ace_sb {
    position: absolute;
    overflow-x: hidden;
    overflow-y: scroll;
    right: 0;
}

.ace_editor .ace_sb div {
    position: absolute;
    width: 1px;
    left: 0;
}

.ace_editor .ace_print_margin_layer {
    z-index: 0;
    position: absolute;
    overflow: hidden;
    margin: 0;
    left: 0;
    height: 100%;
    width: 100%;
}

.ace_editor .ace_print_margin {
    position: absolute;
    height: 100%;
}

.ace_editor > textarea {
    position: absolute;
    z-index: 0;
    width: 0.5em;
    height: 1em;
    opacity: 0;
    background: transparent;
    appearance: none;
    -moz-appearance: none;
    border: none;
    resize: none;
    outline: none;
    overflow: hidden;
}

.ace_editor > textarea.ace_composition {
    background: #fff;
    color: #000;
    z-index: 1000;
    opacity: 1;
    border: solid lightgray 1px;
    margin: -1px
}

.ace_layer {
    z-index: 1;
    position: absolute;
    overflow: hidden;
    white-space: nowrap;
    height: 100%;
    width: 100%;
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    /* setting pointer-events: auto; on node under the mouse, which changes
        during scroll, will break mouse wheel scrolling in Safari */
    pointer-events: none;
}

.ace_gutter .ace_layer {
    position: relative;
    width: auto;
    text-align: right;
    pointer-events: auto;
}

.ace_text-layer {
    color: black;
    font: inherit !important;
}

.ace_cjk {
    display: inline-block;
    text-align: center;
}

.ace_cursor-layer {
    z-index: 4;
}

.ace_cursor {
    z-index: 4;
    position: absolute;
}

.ace_cursor.ace_hidden {
    opacity: 0.2;
}

.ace_editor.multiselect .ace_cursor {
    border-left-width: 1px;
}

.ace_line {
    white-space: nowrap;
}

.ace_marker-layer .ace_step {
    position: absolute;
    z-index: 3;
}

.ace_marker-layer .ace_selection {
    position: absolute;
    z-index: 5;
}

.ace_marker-layer .ace_bracket {
    position: absolute;
    z-index: 6;
}

.ace_marker-layer .ace_active_line {
    position: absolute;
    z-index: 2;
}

.ace_marker-layer .ace_selected_word {
    position: absolute;
    z-index: 4;
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
}

.ace_line .ace_fold {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;

    display: inline-block;
    height: 11px;
    margin-top: -2px;
    vertical-align: middle;

    background-image:
        url("data:image/png,%89PNG%0D%0A%1A%0A%00%00%00%0DIHDR%00%00%00%11%00%00%00%09%08%06%00%00%00%D4%E8%C7%0C%00%00%03%1EiCCPICC%20Profile%00%00x%01%85T%DFk%D3P%14%FE%DAe%9D%B0%E1%8B%3Ag%11%09%3Eh%91ndStC%9C%B6kW%BA%CDZ%EA6%B7!H%9B%A6m%5C%9A%C6%24%ED~%B0%07%D9%8Bo%3A%C5w%F1%07%3E%F9%07%0C%D9%83o%7B%92%0D%C6%14a%F8%AC%88%22L%F6%22%B3%9E%9B4M'S%03%B9%F7%BB%DF%F9%EE9'%E7%E4%5E%A0%F9qZ%D3%14%2F%0F%14USO%C5%C2%FC%C4%E4%14%DF%F2%01%5E%1CC%2B%FChM%8B%86%16J%26G%40%0F%D3%B2y%EF%B3%F3%0E%1E%C6lt%EEo%DF%AB%FEc%D5%9A%95%0C%11%F0%1C%20%BE%945%C4%22%E1Y%A0i%5C%D4t%13%E0%D6%89%EF%9D15%C2%CDLsX%A7%04%09%1Fg8oc%81%E1%8C%8D%23%96f45%40%9A%09%C2%07%C5B%3AK%B8%408%98i%E0%F3%0D%D8%CE%81%14%E4'%26%A9%92.%8B%3C%ABER%2F%E5dE%B2%0C%F6%F0%1Fs%83%F2_%B0%A8%94%E9%9B%AD%E7%10%8Dm%9A%19N%D1%7C%8A%DE%1F9%7Dp%8C%E6%00%D5%C1%3F_%18%BDA%B8%9DpX6%E3%A35~B%CD%24%AE%11%26%BD%E7%EEti%98%EDe%9A%97Y)%12%25%1C%24%BCbT%AE3li%E6%0B%03%89%9A%E6%D3%ED%F4P%92%B0%9F4%BF43Y%F3%E3%EDP%95%04%EB1%C5%F5%F6KF%F4%BA%BD%D7%DB%91%93%07%E35%3E%A7)%D6%7F%40%FE%BD%F7%F5r%8A%E5y%92%F0%EB%B4%1E%8D%D5%F4%5B%92%3AV%DB%DB%E4%CD%A6%23%C3%C4wQ%3F%03HB%82%8E%1Cd(%E0%91B%0Ca%9Ac%C4%AA%F8L%16%19%22J%A4%D2itTy%B28%D6%3B(%93%96%ED%1CGx%C9_%0E%B8%5E%16%F5%5B%B2%B8%F6%E0%FB%9E%DD%25%D7%8E%BC%15%85%C5%B7%A3%D8Q%ED%B5%81%E9%BA%B2%13%9A%1B%7Fua%A5%A3n%E17%B9%E5%9B%1Bm%AB%0B%08Q%FE%8A%E5%B1H%5Ee%CAO%82Q%D7u6%E6%90S%97%FCu%0B%CF2%94%EE%25v%12X%0C%BA%AC%F0%5E%F8*l%0AO%85%17%C2%97%BF%D4%C8%CE%DE%AD%11%CB%80q%2C%3E%AB%9ES%CD%C6%EC%25%D2L%D2%EBd%B8%BF%8A%F5B%C6%18%F9%901CZ%9D%BE%24M%9C%8A9%F2%DAP%0B'%06w%82%EB%E6%E2%5C%2F%D7%07%9E%BB%CC%5D%E1%FA%B9%08%AD.r%23%8E%C2%17%F5E%7C!%F0%BE3%BE%3E_%B7o%88a%A7%DB%BE%D3d%EB%A31Z%EB%BB%D3%91%BA%A2%B1z%94%8F%DB'%F6%3D%8E%AA%13%19%B2%B1%BE%B1~V%08%2B%B4%A2cjJ%B3tO%00%03%25mN%97%F3%05%93%EF%11%84%0B%7C%88%AE-%89%8F%ABbW%90O%2B%0Ao%99%0C%5E%97%0CI%AFH%D9.%B0%3B%8F%ED%03%B6S%D6%5D%E6i_s9%F3*p%E9%1B%FD%C3%EB.7U%06%5E%19%C0%D1s.%17%A03u%E4%09%B0%7C%5E%2C%EB%15%DB%1F%3C%9E%B7%80%91%3B%DBc%AD%3Dma%BA%8B%3EV%AB%DBt.%5B%1E%01%BB%0F%AB%D5%9F%CF%AA%D5%DD%E7%E4%7F%0Bx%A3%FC%06%A9%23%0A%D6%C2%A1_2%00%00%00%09pHYs%00%00%0B%13%00%00%0B%13%01%00%9A%9C%18%00%00%00%B5IDAT(%15%A5%91%3D%0E%02!%10%85ac%E1%05%D6%CE%D6%C6%CE%D2%E8%ED%CD%DE%C0%C6%D6N.%E0V%F8%3D%9Ca%891XH%C2%BE%D9y%3F%90!%E6%9C%C3%BFk%E5%011%C6-%F5%C8N%04%DF%BD%FF%89%DFt%83DN%60%3E%F3%AB%A0%DE%1A%5Dg%BE%10Q%97%1B%40%9C%A8o%10%8F%5E%828%B4%1B%60%87%F6%02%26%85%1Ch%1E%C1%2B%5Bk%FF%86%EE%B7j%09%9A%DA%9B%ACe%A3%F9%EC%DA!9%B4%D5%A6%81%86%86%98%CC%3C%5B%40%FA%81%B3%E9%CB%23%94%C16Azo%05%D4%E1%C1%95a%3B%8A'%A0%E8%CC%17%22%85%1D%BA%00%A2%FA%DC%0A%94%D1%D1%8D%8B%3A%84%17B%C7%60%1A%25Z%FC%8D%00%00%00%00IEND%AEB%60%82"),
        url("data:image/png,%89PNG%0D%0A%1A%0A%00%00%00%0DIHDR%00%00%00%05%00%00%007%08%06%00%00%00%C4%DD%80C%00%00%03%1EiCCPICC%20Profile%00%00x%01%85T%DFk%D3P%14%FE%DAe%9D%B0%E1%8B%3Ag%11%09%3Eh%91ndStC%9C%B6kW%BA%CDZ%EA6%B7!H%9B%A6m%5C%9A%C6%24%ED~%B0%07%D9%8Bo%3A%C5w%F1%07%3E%F9%07%0C%D9%83o%7B%92%0D%C6%14a%F8%AC%88%22L%F6%22%B3%9E%9B4M'S%03%B9%F7%BB%DF%F9%EE9'%E7%E4%5E%A0%F9qZ%D3%14%2F%0F%14USO%C5%C2%FC%C4%E4%14%DF%F2%01%5E%1CC%2B%FChM%8B%86%16J%26G%40%0F%D3%B2y%EF%B3%F3%0E%1E%C6lt%EEo%DF%AB%FEc%D5%9A%95%0C%11%F0%1C%20%BE%945%C4%22%E1Y%A0i%5C%D4t%13%E0%D6%89%EF%9D15%C2%CDLsX%A7%04%09%1Fg8oc%81%E1%8C%8D%23%96f45%40%9A%09%C2%07%C5B%3AK%B8%408%98i%E0%F3%0D%D8%CE%81%14%E4'%26%A9%92.%8B%3C%ABER%2F%E5dE%B2%0C%F6%F0%1Fs%83%F2_%B0%A8%94%E9%9B%AD%E7%10%8Dm%9A%19N%D1%7C%8A%DE%1F9%7Dp%8C%E6%00%D5%C1%3F_%18%BDA%B8%9DpX6%E3%A35~B%CD%24%AE%11%26%BD%E7%EEti%98%EDe%9A%97Y)%12%25%1C%24%BCbT%AE3li%E6%0B%03%89%9A%E6%D3%ED%F4P%92%B0%9F4%BF43Y%F3%E3%EDP%95%04%EB1%C5%F5%F6KF%F4%BA%BD%D7%DB%91%93%07%E35%3E%A7)%D6%7F%40%FE%BD%F7%F5r%8A%E5y%92%F0%EB%B4%1E%8D%D5%F4%5B%92%3AV%DB%DB%E4%CD%A6%23%C3%C4wQ%3F%03HB%82%8E%1Cd(%E0%91B%0Ca%9Ac%C4%AA%F8L%16%19%22J%A4%D2itTy%B28%D6%3B(%93%96%ED%1CGx%C9_%0E%B8%5E%16%F5%5B%B2%B8%F6%E0%FB%9E%DD%25%D7%8E%BC%15%85%C5%B7%A3%D8Q%ED%B5%81%E9%BA%B2%13%9A%1B%7Fua%A5%A3n%E17%B9%E5%9B%1Bm%AB%0B%08Q%FE%8A%E5%B1H%5Ee%CAO%82Q%D7u6%E6%90S%97%FCu%0B%CF2%94%EE%25v%12X%0C%BA%AC%F0%5E%F8*l%0AO%85%17%C2%97%BF%D4%C8%CE%DE%AD%11%CB%80q%2C%3E%AB%9ES%CD%C6%EC%25%D2L%D2%EBd%B8%BF%8A%F5B%C6%18%F9%901CZ%9D%BE%24M%9C%8A9%F2%DAP%0B'%06w%82%EB%E6%E2%5C%2F%D7%07%9E%BB%CC%5D%E1%FA%B9%08%AD.r%23%8E%C2%17%F5E%7C!%F0%BE3%BE%3E_%B7o%88a%A7%DB%BE%D3d%EB%A31Z%EB%BB%D3%91%BA%A2%B1z%94%8F%DB'%F6%3D%8E%AA%13%19%B2%B1%BE%B1~V%08%2B%B4%A2cjJ%B3tO%00%03%25mN%97%F3%05%93%EF%11%84%0B%7C%88%AE-%89%8F%ABbW%90O%2B%0Ao%99%0C%5E%97%0CI%AFH%D9.%B0%3B%8F%ED%03%B6S%D6%5D%E6i_s9%F3*p%E9%1B%FD%C3%EB.7U%06%5E%19%C0%D1s.%17%A03u%E4%09%B0%7C%5E%2C%EB%15%DB%1F%3C%9E%B7%80%91%3B%DBc%AD%3Dma%BA%8B%3EV%AB%DBt.%5B%1E%01%BB%0F%AB%D5%9F%CF%AA%D5%DD%E7%E4%7F%0Bx%A3%FC%06%A9%23%0A%D6%C2%A1_2%00%00%00%09pHYs%00%00%0B%13%00%00%0B%13%01%00%9A%9C%18%00%00%00%3AIDAT8%11c%FC%FF%FF%7F%18%03%1A%60%01%F2%3F%A0%891%80%04%FF%11-%F8%17%9BJ%E2%05%B1ZD%81v%26t%E7%80%F8%A3%82h%A12%1A%20%A3%01%02%0F%01%BA%25%06%00%19%C0%0D%AEF%D5%3ES%00%00%00%00IEND%AEB%60%82");
    background-repeat: no-repeat, repeat-x;
    background-position: center center, top left;
    color: transparent;

    border: 1px solid black;
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;

    cursor: pointer;
    pointer-events: auto;
}

.ace_dark .ace_fold {
}

.ace_fold:hover{
    background-image:
        url("data:image/png,%89PNG%0D%0A%1A%0A%00%00%00%0DIHDR%00%00%00%11%00%00%00%09%08%06%00%00%00%D4%E8%C7%0C%00%00%03%1EiCCPICC%20Profile%00%00x%01%85T%DFk%D3P%14%FE%DAe%9D%B0%E1%8B%3Ag%11%09%3Eh%91ndStC%9C%B6kW%BA%CDZ%EA6%B7!H%9B%A6m%5C%9A%C6%24%ED~%B0%07%D9%8Bo%3A%C5w%F1%07%3E%F9%07%0C%D9%83o%7B%92%0D%C6%14a%F8%AC%88%22L%F6%22%B3%9E%9B4M'S%03%B9%F7%BB%DF%F9%EE9'%E7%E4%5E%A0%F9qZ%D3%14%2F%0F%14USO%C5%C2%FC%C4%E4%14%DF%F2%01%5E%1CC%2B%FChM%8B%86%16J%26G%40%0F%D3%B2y%EF%B3%F3%0E%1E%C6lt%EEo%DF%AB%FEc%D5%9A%95%0C%11%F0%1C%20%BE%945%C4%22%E1Y%A0i%5C%D4t%13%E0%D6%89%EF%9D15%C2%CDLsX%A7%04%09%1Fg8oc%81%E1%8C%8D%23%96f45%40%9A%09%C2%07%C5B%3AK%B8%408%98i%E0%F3%0D%D8%CE%81%14%E4'%26%A9%92.%8B%3C%ABER%2F%E5dE%B2%0C%F6%F0%1Fs%83%F2_%B0%A8%94%E9%9B%AD%E7%10%8Dm%9A%19N%D1%7C%8A%DE%1F9%7Dp%8C%E6%00%D5%C1%3F_%18%BDA%B8%9DpX6%E3%A35~B%CD%24%AE%11%26%BD%E7%EEti%98%EDe%9A%97Y)%12%25%1C%24%BCbT%AE3li%E6%0B%03%89%9A%E6%D3%ED%F4P%92%B0%9F4%BF43Y%F3%E3%EDP%95%04%EB1%C5%F5%F6KF%F4%BA%BD%D7%DB%91%93%07%E35%3E%A7)%D6%7F%40%FE%BD%F7%F5r%8A%E5y%92%F0%EB%B4%1E%8D%D5%F4%5B%92%3AV%DB%DB%E4%CD%A6%23%C3%C4wQ%3F%03HB%82%8E%1Cd(%E0%91B%0Ca%9Ac%C4%AA%F8L%16%19%22J%A4%D2itTy%B28%D6%3B(%93%96%ED%1CGx%C9_%0E%B8%5E%16%F5%5B%B2%B8%F6%E0%FB%9E%DD%25%D7%8E%BC%15%85%C5%B7%A3%D8Q%ED%B5%81%E9%BA%B2%13%9A%1B%7Fua%A5%A3n%E17%B9%E5%9B%1Bm%AB%0B%08Q%FE%8A%E5%B1H%5Ee%CAO%82Q%D7u6%E6%90S%97%FCu%0B%CF2%94%EE%25v%12X%0C%BA%AC%F0%5E%F8*l%0AO%85%17%C2%97%BF%D4%C8%CE%DE%AD%11%CB%80q%2C%3E%AB%9ES%CD%C6%EC%25%D2L%D2%EBd%B8%BF%8A%F5B%C6%18%F9%901CZ%9D%BE%24M%9C%8A9%F2%DAP%0B'%06w%82%EB%E6%E2%5C%2F%D7%07%9E%BB%CC%5D%E1%FA%B9%08%AD.r%23%8E%C2%17%F5E%7C!%F0%BE3%BE%3E_%B7o%88a%A7%DB%BE%D3d%EB%A31Z%EB%BB%D3%91%BA%A2%B1z%94%8F%DB'%F6%3D%8E%AA%13%19%B2%B1%BE%B1~V%08%2B%B4%A2cjJ%B3tO%00%03%25mN%97%F3%05%93%EF%11%84%0B%7C%88%AE-%89%8F%ABbW%90O%2B%0Ao%99%0C%5E%97%0CI%AFH%D9.%B0%3B%8F%ED%03%B6S%D6%5D%E6i_s9%F3*p%E9%1B%FD%C3%EB.7U%06%5E%19%C0%D1s.%17%A03u%E4%09%B0%7C%5E%2C%EB%15%DB%1F%3C%9E%B7%80%91%3B%DBc%AD%3Dma%BA%8B%3EV%AB%DBt.%5B%1E%01%BB%0F%AB%D5%9F%CF%AA%D5%DD%E7%E4%7F%0Bx%A3%FC%06%A9%23%0A%D6%C2%A1_2%00%00%00%09pHYs%00%00%0B%13%00%00%0B%13%01%00%9A%9C%18%00%00%00%B5IDAT(%15%A5%91%3D%0E%02!%10%85ac%E1%05%D6%CE%D6%C6%CE%D2%E8%ED%CD%DE%C0%C6%D6N.%E0V%F8%3D%9Ca%891XH%C2%BE%D9y%3F%90!%E6%9C%C3%BFk%E5%011%C6-%F5%C8N%04%DF%BD%FF%89%DFt%83DN%60%3E%F3%AB%A0%DE%1A%5Dg%BE%10Q%97%1B%40%9C%A8o%10%8F%5E%828%B4%1B%60%87%F6%02%26%85%1Ch%1E%C1%2B%5Bk%FF%86%EE%B7j%09%9A%DA%9B%ACe%A3%F9%EC%DA!9%B4%D5%A6%81%86%86%98%CC%3C%5B%40%FA%81%B3%E9%CB%23%94%C16Azo%05%D4%E1%C1%95a%3B%8A'%A0%E8%CC%17%22%85%1D%BA%00%A2%FA%DC%0A%94%D1%D1%8D%8B%3A%84%17B%C7%60%1A%25Z%FC%8D%00%00%00%00IEND%AEB%60%82"),
        url("data:image/png,%89PNG%0D%0A%1A%0A%00%00%00%0DIHDR%00%00%00%05%00%00%007%08%06%00%00%00%C4%DD%80C%00%00%03%1EiCCPICC%20Profile%00%00x%01%85T%DFk%D3P%14%FE%DAe%9D%B0%E1%8B%3Ag%11%09%3Eh%91ndStC%9C%B6kW%BA%CDZ%EA6%B7!H%9B%A6m%5C%9A%C6%24%ED~%B0%07%D9%8Bo%3A%C5w%F1%07%3E%F9%07%0C%D9%83o%7B%92%0D%C6%14a%F8%AC%88%22L%F6%22%B3%9E%9B4M'S%03%B9%F7%BB%DF%F9%EE9'%E7%E4%5E%A0%F9qZ%D3%14%2F%0F%14USO%C5%C2%FC%C4%E4%14%DF%F2%01%5E%1CC%2B%FChM%8B%86%16J%26G%40%0F%D3%B2y%EF%B3%F3%0E%1E%C6lt%EEo%DF%AB%FEc%D5%9A%95%0C%11%F0%1C%20%BE%945%C4%22%E1Y%A0i%5C%D4t%13%E0%D6%89%EF%9D15%C2%CDLsX%A7%04%09%1Fg8oc%81%E1%8C%8D%23%96f45%40%9A%09%C2%07%C5B%3AK%B8%408%98i%E0%F3%0D%D8%CE%81%14%E4'%26%A9%92.%8B%3C%ABER%2F%E5dE%B2%0C%F6%F0%1Fs%83%F2_%B0%A8%94%E9%9B%AD%E7%10%8Dm%9A%19N%D1%7C%8A%DE%1F9%7Dp%8C%E6%00%D5%C1%3F_%18%BDA%B8%9DpX6%E3%A35~B%CD%24%AE%11%26%BD%E7%EEti%98%EDe%9A%97Y)%12%25%1C%24%BCbT%AE3li%E6%0B%03%89%9A%E6%D3%ED%F4P%92%B0%9F4%BF43Y%F3%E3%EDP%95%04%EB1%C5%F5%F6KF%F4%BA%BD%D7%DB%91%93%07%E35%3E%A7)%D6%7F%40%FE%BD%F7%F5r%8A%E5y%92%F0%EB%B4%1E%8D%D5%F4%5B%92%3AV%DB%DB%E4%CD%A6%23%C3%C4wQ%3F%03HB%82%8E%1Cd(%E0%91B%0Ca%9Ac%C4%AA%F8L%16%19%22J%A4%D2itTy%B28%D6%3B(%93%96%ED%1CGx%C9_%0E%B8%5E%16%F5%5B%B2%B8%F6%E0%FB%9E%DD%25%D7%8E%BC%15%85%C5%B7%A3%D8Q%ED%B5%81%E9%BA%B2%13%9A%1B%7Fua%A5%A3n%E17%B9%E5%9B%1Bm%AB%0B%08Q%FE%8A%E5%B1H%5Ee%CAO%82Q%D7u6%E6%90S%97%FCu%0B%CF2%94%EE%25v%12X%0C%BA%AC%F0%5E%F8*l%0AO%85%17%C2%97%BF%D4%C8%CE%DE%AD%11%CB%80q%2C%3E%AB%9ES%CD%C6%EC%25%D2L%D2%EBd%B8%BF%8A%F5B%C6%18%F9%901CZ%9D%BE%24M%9C%8A9%F2%DAP%0B'%06w%82%EB%E6%E2%5C%2F%D7%07%9E%BB%CC%5D%E1%FA%B9%08%AD.r%23%8E%C2%17%F5E%7C!%F0%BE3%BE%3E_%B7o%88a%A7%DB%BE%D3d%EB%A31Z%EB%BB%D3%91%BA%A2%B1z%94%8F%DB'%F6%3D%8E%AA%13%19%B2%B1%BE%B1~V%08%2B%B4%A2cjJ%B3tO%00%03%25mN%97%F3%05%93%EF%11%84%0B%7C%88%AE-%89%8F%ABbW%90O%2B%0Ao%99%0C%5E%97%0CI%AFH%D9.%B0%3B%8F%ED%03%B6S%D6%5D%E6i_s9%F3*p%E9%1B%FD%C3%EB.7U%06%5E%19%C0%D1s.%17%A03u%E4%09%B0%7C%5E%2C%EB%15%DB%1F%3C%9E%B7%80%91%3B%DBc%AD%3Dma%BA%8B%3EV%AB%DBt.%5B%1E%01%BB%0F%AB%D5%9F%CF%AA%D5%DD%E7%E4%7F%0Bx%A3%FC%06%A9%23%0A%D6%C2%A1_2%00%00%00%09pHYs%00%00%0B%13%00%00%0B%13%01%00%9A%9C%18%00%00%003IDAT8%11c%FC%FF%FF%7F%3E%03%1A%60%01%F2%3F%A3%891%80%04%FFQ%26%F8w%C0%B43%A1%DB%0C%E2%8F%0A%A2%85%CAh%80%8C%06%08%3C%04%E8%96%18%00%A3S%0D%CD%CF%D8%C1%9D%00%00%00%00IEND%AEB%60%82");
    background-repeat: no-repeat, repeat-x;
    background-position: center center, top left;
}

.ace_dragging .ace_content {
    cursor: move;
}

.ace_gutter_tooltip {
    background-color: #FFFFD5;
    border: 1px solid gray;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
    color: black;
    display: inline-block;
    padding: 4px;
    position: absolute;
    z-index: 300;
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    cursor: default;
}

.ace_folding-enabled > .ace_gutter-cell {
    padding-right: 13px;
}

.ace_fold-widget {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;

    margin: 0 -12px 1px 1px;
    display: inline-block;
    height: 14px;
    width: 11px;
    vertical-align: text-bottom;

    background-image: url("data:image/png,%89PNG%0D%0A%1A%0A%00%00%00%0DIHDR%00%00%00%05%00%00%00%05%08%06%00%00%00%8Do%26%E5%00%00%004IDATx%DAe%8A%B1%0D%000%0C%C2%F2%2CK%96%BC%D0%8F9%81%88H%E9%D0%0E%96%C0%10%92%3E%02%80%5E%82%E4%A9*-%EEsw%C8%CC%11%EE%96w%D8%DC%E9*Eh%0C%151(%00%00%00%00IEND%AEB%60%82");
    background-repeat: no-repeat;
    background-position: center 4px;

    border-radius: 3px;
    
    border: 1px solid transparent;
}

.ace_fold-widget.end {
    background-image: url("data:image/png,%89PNG%0D%0A%1A%0A%00%00%00%0DIHDR%00%00%00%05%00%00%00%05%08%06%00%00%00%8Do%26%E5%00%00%004IDATx%DAm%C7%C1%09%000%08C%D1%8C%ECE%C8E(%8E%EC%02)%1EZJ%F1%C1'%04%07I%E1%E5%EE%CAL%F5%A2%99%99%22%E2%D6%1FU%B5%FE0%D9x%A7%26Wz5%0E%D5%00%00%00%00IEND%AEB%60%82");
}

.ace_fold-widget.closed {
    background-image: url("data:image/png,%89PNG%0D%0A%1A%0A%00%00%00%0DIHDR%00%00%00%03%00%00%00%06%08%06%00%00%00%06%E5%24%0C%00%00%009IDATx%DA5%CA%C1%09%000%08%03%C0%AC*(%3E%04%C1%0D%BA%B1%23%A4Uh%E0%20%81%C0%CC%F8%82%81%AA%A2%AArGfr%88%08%11%11%1C%DD%7D%E0%EE%5B%F6%F6%CB%B8%05Q%2F%E9tai%D9%00%00%00%00IEND%AEB%60%82");
}

.ace_fold-widget:hover {
    border: 1px solid rgba(0, 0, 0, 0.3);
    background-color: rgba(255, 255, 255, 0.2);
    -moz-box-shadow: 0 1px 1px rgba(255, 255, 255, 0.7);
    -webkit-box-shadow: 0 1px 1px rgba(255, 255, 255, 0.7);
    box-shadow: 0 1px 1px rgba(255, 255, 255, 0.7);
    background-position: center 4px;
}

.ace_fold-widget:active {
    border: 1px solid rgba(0, 0, 0, 0.4);
    background-color: rgba(0, 0, 0, 0.05);
    -moz-box-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
    -webkit-box-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
    box-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
}
/**
 * Dark version for fold widgets
 */
.ace_dark .ace_fold-widget {
    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAHklEQVQIW2P4//8/AzoGEQ7oGCaLLAhWiSwB146BAQCSTPYocqT0AAAAAElFTkSuQmCC");
}
.ace_dark .ace_fold-widget.end {
    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAH0lEQVQIW2P4//8/AxQ7wNjIAjDMgC4AxjCVKBirIAAF0kz2rlhxpAAAAABJRU5ErkJggg==");
}
.ace_dark .ace_fold-widget.closed {
    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAMAAAAFCAYAAACAcVaiAAAAHElEQVQIW2P4//+/AxAzgDADlOOAznHAKgPWAwARji8UIDTfQQAAAABJRU5ErkJggg==");
}
.ace_dark .ace_fold-widget:hover {
    box-shadow: 0 1px 1px rgba(255, 255, 255, 0.2);
    background-color: rgba(255, 255, 255, 0.1);
}
.ace_dark .ace_fold-widget:active {
    -moz-box-shadow: 0 1px 1px rgba(255, 255, 255, 0.2);
    -webkit-box-shadow: 0 1px 1px rgba(255, 255, 255, 0.2);
    box-shadow: 0 1px 1px rgba(255, 255, 255, 0.2);
}
    
    
    
.ace_fold-widget.invalid {
    background-color: #FFB4B4;
    border-color: #DE5555;
}

.ace_fade-fold-widgets .ace_fold-widget {
       -moz-transition: opacity 0.4s ease 0.05s;
    -webkit-transition: opacity 0.4s ease 0.05s;
         -o-transition: opacity 0.4s ease 0.05s;
        -ms-transition: opacity 0.4s ease 0.05s;
            transition: opacity 0.4s ease 0.05s;
    opacity: 0;
}

.ace_fade-fold-widgets:hover .ace_fold-widget {
       -moz-transition: opacity 0.05s ease 0.05s;
    -webkit-transition: opacity 0.05s ease 0.05s;
         -o-transition: opacity 0.05s ease 0.05s;
        -ms-transition: opacity 0.05s ease 0.05s;
            transition: opacity 0.05s ease 0.05s;
    opacity:1;
}
</style><style id="ace-tm">.ace-tm .ace_editor {
  border: 2px solid rgb(159, 159, 159);
}

.ace-tm .ace_editor.ace_focus {
  border: 2px solid #327fbd;
}

.ace-tm .ace_gutter {
  background: #f0f0f0;
  color: #333;
}

.ace-tm .ace_print_margin {
  width: 1px;
  background: #e8e8e8;
}

.ace-tm .ace_fold {
    background-color: #6B72E6;
}

.ace-tm .ace_text-layer {
}

.ace-tm .ace_cursor {
  border-left: 2px solid black;
}

.ace-tm .ace_cursor.ace_overwrite {
  border-left: 0px;
  border-bottom: 1px solid black;
}
        
.ace-tm .ace_line .ace_invisible {
  color: rgb(191, 191, 191);
}

.ace-tm .ace_line .ace_storage,
.ace-tm .ace_line .ace_keyword {
  color: blue;
}

.ace-tm .ace_line .ace_constant {
  color: rgb(197, 6, 11);
}

.ace-tm .ace_line .ace_constant.ace_buildin {
  color: rgb(88, 72, 246);
}

.ace-tm .ace_line .ace_constant.ace_language {
  color: rgb(88, 92, 246);
}

.ace-tm .ace_line .ace_constant.ace_library {
  color: rgb(6, 150, 14);
}

.ace-tm .ace_line .ace_invalid {
  background-color: rgba(255, 0, 0, 0.1);
  color: red;
}

.ace-tm .ace_line .ace_support.ace_function {
  color: rgb(60, 76, 114);
}

.ace-tm .ace_line .ace_support.ace_constant {
  color: rgb(6, 150, 14);
}

.ace-tm .ace_line .ace_support.ace_type,
.ace-tm .ace_line .ace_support.ace_class {
  color: rgb(109, 121, 222);
}

.ace-tm .ace_line .ace_keyword.ace_operator {
  color: rgb(104, 118, 135);
}

.ace-tm .ace_line .ace_string {
  color: rgb(3, 106, 7);
}

.ace-tm .ace_line .ace_comment {
  color: rgb(76, 136, 107);
}

.ace-tm .ace_line .ace_comment.ace_doc {
  color: rgb(0, 102, 255);
}

.ace-tm .ace_line .ace_comment.ace_doc.ace_tag {
  color: rgb(128, 159, 191);
}

.ace-tm .ace_line .ace_constant.ace_numeric {
  color: rgb(0, 0, 205);
}

.ace-tm .ace_line .ace_variable {
  color: rgb(49, 132, 149);
}

.ace-tm .ace_line .ace_xml_pe {
  color: rgb(104, 104, 91);
}

.ace-tm .ace_entity.ace_name.ace_function {
  color: #0000A2;
}

.ace-tm .ace_markup.ace_markupine {
    text-decoration:underline;
}

.ace-tm .ace_markup.ace_heading {
  color: rgb(12, 7, 255);
}

.ace-tm .ace_markup.ace_list {
  color:rgb(185, 6, 144);
}

.ace-tm .ace_marker-layer .ace_selection {
  background: rgb(181, 213, 255);
}
.ace-tm.multiselect .ace_selection.start {
  box-shadow: 0 0 3px 0px white;
  border-radius: 2px;
}
.ace-tm .ace_marker-layer .ace_step {
  background: rgb(252, 255, 0);
}

.ace-tm .ace_marker-layer .ace_stack {
  background: rgb(164, 229, 101);
}

.ace-tm .ace_marker-layer .ace_bracket {
  margin: -1px 0 0 -1px;
  border: 1px solid rgb(192, 192, 192);
}

.ace-tm .ace_marker-layer .ace_active_line {
  background: rgba(0, 0, 0, 0.07);
}

.ace-tm .ace_gutter_active_line {
    background-color : #dcdcdc;
}

.ace-tm .ace_marker-layer .ace_selected_word {
  background: rgb(250, 250, 255);
  border: 1px solid rgb(200, 200, 250);
}

.ace-tm .ace_meta.ace_tag {
  color:rgb(0, 22, 142);
}

.ace-tm .ace_string.ace_regex {
  color: rgb(255, 0, 0)
}

.ace-tm .ace_indent-guide {
  background: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAACCAYAAACZgbYnAAAAE0lEQVQImWP4////f4bLly//BwAmVgd1/w11/gAAAABJRU5ErkJggg==") right repeat-y;
}
</style><script src="./README_files/mode-markdown.js"></script><script src="./README_files/theme-monokai.js"></script><style id="ace-monokai">.ace-monokai .ace_editor {  border: 2px solid rgb(159, 159, 159);}.ace-monokai .ace_editor.ace_focus {  border: 2px solid #327fbd;}.ace-monokai .ace_gutter {  background: #2f3129;  color: #f1f1f1;}.ace-monokai .ace_print_margin {  width: 1px;  background: #555651;}.ace-monokai .ace_scroller {  background-color: #272822;}.ace-monokai .ace_text-layer {  color: #F8F8F2;}.ace-monokai .ace_cursor {  border-left: 2px solid #F8F8F0;}.ace-monokai .ace_cursor.ace_overwrite {  border-left: 0px;  border-bottom: 1px solid #F8F8F0;}.ace-monokai .ace_marker-layer .ace_selection {  background: #49483E;}.ace-monokai.multiselect .ace_selection.start {  box-shadow: 0 0 3px 0px #272822;  border-radius: 2px;}.ace-monokai .ace_marker-layer .ace_step {  background: rgb(102, 82, 0);}.ace-monokai .ace_marker-layer .ace_bracket {  margin: -1px 0 0 -1px;  border: 1px solid #49483E;}.ace-monokai .ace_marker-layer .ace_active_line {  background: #49483E;}.ace-monokai .ace_gutter_active_line {  background-color: #191916;}.ace-monokai .ace_marker-layer .ace_selected_word {  border: 1px solid #49483E;}.ace-monokai .ace_invisible {  color: #49483E;}.ace-monokai .ace_keyword, .ace-monokai .ace_meta {  color:#F92672;}.ace-monokai .ace_constant.ace_language {  color:#AE81FF;}.ace-monokai .ace_constant.ace_numeric {  color:#AE81FF;}.ace-monokai .ace_constant.ace_other {  color:#AE81FF;}.ace-monokai .ace_invalid {  color:#F8F8F0;background-color:#F92672;}.ace-monokai .ace_invalid.ace_deprecated {  color:#F8F8F0;background-color:#AE81FF;}.ace-monokai .ace_support.ace_constant {  color:#66D9EF;}.ace-monokai .ace_fold {    background-color: #A6E22E;    border-color: #F8F8F2;}.ace-monokai .ace_support.ace_function {  color:#66D9EF;}.ace-monokai .ace_storage {  color:#F92672;}.ace-monokai .ace_storage.ace_type,  .ace-monokai .ace_support.ace_type{  font-style:italic;color:#66D9EF;}.ace-monokai .ace_variable {  color:#A6E22E;}.ace-monokai .ace_variable.ace_parameter {  font-style:italic;color:#FD971F;}.ace-monokai .ace_string {  color:#E6DB74;}.ace-monokai .ace_comment {  color:#75715E;}.ace-monokai .ace_entity.ace_other.ace_attribute-name {  color:#A6E22E;}.ace-monokai .ace_entity.ace_name.ace_function {  color:#A6E22E;}.ace-monokai .ace_markup.ace_underline {    text-decoration:underline;}.ace-monokai .ace_indent-guide {  background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAACCAYAAACZgbYnAAAAEklEQVQImWNQ11D6z7Bq1ar/ABCKBG6g04U2AAAAAElFTkSuQmCC) right repeat-y;}</style></head>
<body>
    <div class="mahua-container">
        <div id="mahua-docname" class="mahua-docanme" style="left: 922.5px;">README</div>
        <ul class="mahua-topbar" id="mahua-topbar">
          <li class="mahua-github" id="mahua-github"><a href="https://github.com/jserme/mahua" target="_blank"><img src="./README_files/github.png"></a></li>
            <li class="mahua-config" id="mahua-config"></li>
            <li class="mahua-session" id="mahua-session"></li>
        </ul>
        <div class="mahua-toolbar" style="display:none" id="mahua-toolbar">
            <table cellspacing="0">
                <tbody><tr>
                    <td> 
                        <label for="mahua-changeSession">选择文档</label>
                    </td>
                    <td>
                        <select id="mahua-changeSession" name=""> <option value="MaHua简介">MaHua简介</option><option value="Markdown语法参考">Markdown语法参考</option><option value="README" selected="">README</option></select> 
                        <a href="javascript:;" id="mahua-removeSession">删除</a>
                    </td>
                </tr>
                <tr>
                    <td> 
                        <label for="mahua-editorThemes">编辑器主题</label>
                    </td>
                    <td>
                        <select id="mahua-editorThemes" name=""> <option value="chrome">chrome</option><option value="clouds">clouds</option><option value="clouds_midnight">clouds_midnight</option><option value="cobalt">cobalt</option><option value="crimson_editor">crimson_editor</option><option value="dawn">dawn</option><option value="dreamweaver">dreamweaver</option><option value="eclipse">eclipse</option><option value="github">github</option><option value="idle_fingers">idle_fingers</option><option value="kr_theme">kr_theme</option><option value="merbivore">merbivore</option><option value="merbivore_soft">merbivore_soft</option><option value="mono_industrial">mono_industrial</option><option value="monokai" selected="">monokai</option><option value="pastel_on_dark">pastel_on_dark</option><option value="solarized_dark">solarized_dark</option><option value="solarized_light">solarized_light</option><option value="textmate">textmate</option><option value="tomorrow">tomorrow</option><option value="tomorrow_night">tomorrow_night</option><option value="tomorrow_night_blue">tomorrow_night_blue</option><option value="tomorrow_night_bright">tomorrow_night_bright</option><option value="tomorrow_night_eighties">tomorrow_night_eighties</option><option value="twilight">twilight</option><option value="vibrant_ink">vibrant_ink</option></select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="mahua-previewThemes">预览主题</label>
                    </td>
                    <td>
                        <select id="mahua-previewThemes" name=""><option value="Clearness-Dark">Clearness-Dark</option><option value="Clearness" selected="">Clearness</option><option value="GitHub">GitHub</option><option value="GitHub2">GitHub2</option></select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table cellspacing="0">
                            <tbody><tr>
                                <td>
                                    <label for="mahua-keyboard">VIM快捷键</label>
                                </td>
                                <td>
                                    <input id="mahua-keyboard" type="checkbox" checked="" class="checkbox" value="" name="">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="mahua-linenum">行号<label>
                                </label></label></td>
                                <td>
                                    <input id="mahua-linenum" type="checkbox" checked="" class="checkbox" value="" name="">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="mahua-attachInfo">附加MaHua信息<label>
                                </label></label></td>
                                <td>
                                    <input id="mahua-attachInfo" type="checkbox" checked="" class="checkbox" value="" name="">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="mahua-syncRoll">自动滚动<label>
                                </label></label></td>
                                <td>
                                    <input id="mahua-syncRoll" type="checkbox" class="checkbox" value="" name="">
                                </td>
                            </tr>
                        </tbody></table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input id="mahua-toggleMode" type="button" class="button" value="自定义CSS" name="">
                        <input id="mahua-importSource" type="button" class="button" value="导入" name="">
                        <input id="mahua-exportHTML" type="button" class="button" value="导出" name="">
                        <input id="mahua-closeConfig" type="button" class="button" value="关闭设置" name="">
                    </td>
                </tr>
            </tbody></table>
        </div>
        <div class="mahua-spliter" id="mahua-spliter" style="left: 50%;"></div>
        <div class="mahua-left">
            <div id="mahua-editor" style="height:100%;width:50%;" class=" ace_editor ace-monokai ace_dark ace_focus"><textarea wrap="off" style="top: 251px; height: 14px; width: 6.60938px; left: 143.219px;"></textarea><div class="ace_gutter" style="display: block;"><div class="ace_gutter_active_line" style="top: 252px; height: 14px;"></div><div class="ace_layer ace_gutter-layer ace_folding-enabled" style="margin-top: 0px; height: 963px;"><div class="ace_gutter-cell " style="height:14px;">1</div><div class="ace_gutter-cell " style="height:14px;">2</div><div class="ace_gutter-cell " style="height:14px;">3</div><div class="ace_gutter-cell " style="height:14px;">4</div><div class="ace_gutter-cell " style="height:14px;">5</div><div class="ace_gutter-cell " style="height:14px;">6</div><div class="ace_gutter-cell " style="height:14px;">7</div><div class="ace_gutter-cell " style="height:14px;">8</div><div class="ace_gutter-cell " style="height:14px;">9</div><div class="ace_gutter-cell " style="height:14px;">10</div><div class="ace_gutter-cell " style="height:14px;">11</div><div class="ace_gutter-cell " style="height:14px;">12</div><div class="ace_gutter-cell " style="height:14px;">13</div><div class="ace_gutter-cell " style="height:14px;">14</div><div class="ace_gutter-cell " style="height:14px;">15</div><div class="ace_gutter-cell " style="height:14px;">16</div><div class="ace_gutter-cell " style="height:14px;">17</div><div class="ace_gutter-cell " style="height:14px;">18</div><div class="ace_gutter-cell " style="height:14px;">19</div><div class="ace_gutter-cell " style="height:14px;">20</div><div class="ace_gutter-cell " style="height:14px;">21</div><div class="ace_gutter-cell " style="height:14px;">22</div><div class="ace_gutter-cell " style="height:14px;">23</div><div class="ace_gutter-cell " style="height:14px;">24</div><div class="ace_gutter-cell " style="height:14px;">25</div><div class="ace_gutter-cell " style="height:14px;">26</div><div class="ace_gutter-cell " style="height:14px;">27</div><div class="ace_gutter-cell " style="height:14px;">28</div><div class="ace_gutter-cell " style="height:14px;">29</div><div class="ace_gutter-cell " style="height:14px;">30</div><div class="ace_gutter-cell " style="height:14px;">31</div><div class="ace_gutter-cell " style="height:14px;">32</div><div class="ace_gutter-cell " style="height:14px;">33</div><div class="ace_gutter-cell " style="height:14px;">34</div><div class="ace_gutter-cell " style="height:14px;">35</div><div class="ace_gutter-cell " style="height:14px;">36</div><div class="ace_gutter-cell " style="height:14px;">37</div><div class="ace_gutter-cell " style="height:14px;">38</div><div class="ace_gutter-cell " style="height:14px;">39</div><div class="ace_gutter-cell " style="height:14px;">40</div><div class="ace_gutter-cell " style="height:14px;">41</div><div class="ace_gutter-cell " style="height:14px;">42</div><div class="ace_gutter-cell " style="height:14px;">43</div><div class="ace_gutter-cell " style="height:14px;">44</div><div class="ace_gutter-cell " style="height:14px;">45</div><div class="ace_gutter-cell " style="height:14px;">46</div><div class="ace_gutter-cell " style="height:14px;">47</div><div class="ace_gutter-cell " style="height:14px;">48</div><div class="ace_gutter-cell " style="height:14px;">49</div><div class="ace_gutter-cell " style="height:14px;">50</div><div class="ace_gutter-cell " style="height:14px;">51</div><div class="ace_gutter-cell " style="height:14px;">52</div><div class="ace_gutter-cell " style="height:14px;">53</div><div class="ace_gutter-cell " style="height:14px;">54</div><div class="ace_gutter-cell " style="height:14px;">55</div><div class="ace_gutter-cell " style="height:14px;">56</div><div class="ace_gutter-cell " style="height:14px;">57</div><div class="ace_gutter-cell " style="height:14px;">58</div><div class="ace_gutter-cell " style="height:14px;">59</div><div class="ace_gutter-cell " style="height:14px;">60</div><div class="ace_gutter-cell " style="height:14px;">61</div><div class="ace_gutter-cell " style="height:14px;">62</div><div class="ace_gutter-cell " style="height:14px;">63</div><div class="ace_gutter-cell " style="height:14px;">64</div><div class="ace_gutter-cell " style="height:14px;">65</div><div class="ace_gutter-cell " style="height:14px;">66</div><div class="ace_gutter-cell " style="height:14px;">67</div><div class="ace_gutter-cell " style="height:14px;">68</div></div></div><div class="ace_scroller" style="height: 935px; left: 52px; right: 17px;"><div class="ace_content" style="margin-top: 0px; width: 883px; height: 963px;"><div class="ace_layer ace_marker-layer"><div class="ace_active_line start" style="height:14px;right:0;top:252px;left:0px;"></div><div class="ace_active_line" style="height:14px;width:0px;top:266px;left:0px;"></div><div class="ace_active_line" style="height:0px;right:0;top:266px;left:0px;"></div></div><div class="ace_print_margin_layer"><div class="ace_print_margin" style="left: 532.75px; visibility: hidden;"></div></div><div class="ace_layer ace_text-layer" style="padding: 0px 4px;"><div class="ace_line" style="height:14px"><span class="ace_markup ace_heading ace_2">##</span>GRecyclerView</div><div class="ace_line" style="height:14px"><span class="ace_markup ace_heading ace_6">######</span>Support</div><div class="ace_line" style="height:14px"><span class="ace_markup ace_list">*&nbsp;&nbsp;</span><span class="ace_markup ace_list">support&nbsp;BaseAdapter&nbsp;SwipeAdapter&nbsp;MultiyAdapter</span></div><div class="ace_line" style="height:14px"><span class="ace_markup ace_list">*&nbsp;&nbsp;custom&nbsp;decoration</span></div><div class="ace_line" style="height:14px"><span class="ace_markup ace_list">*&nbsp;&nbsp;custom&nbsp;refresh&nbsp;header&nbsp;and&nbsp;footer</span></div><div class="ace_line" style="height:14px"><span class="ace_markup ace_list">___</span></div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_markup ace_heading ace_2">##</span>Hao&nbsp;to&nbsp;use&nbsp;?&lt;br/&gt;</div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px">&nbsp;###&nbsp;gradle&lt;br/&gt;</div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">`</span><span class="ace_support ace_function">compile&nbsp;'com.binarysatan:GRecyclerView:1.0'</span><span class="ace_support ace_function">`</span></div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px">&nbsp;###&nbsp;maven&lt;br/&gt;</div><div class="ace_line" style="height:14px">&nbsp;`&lt;dependency&gt;</div><div class="ace_line" style="height:14px">&nbsp;&nbsp;&lt;groupId&gt;com.binarysatan&lt;/groupId&gt;</div><div class="ace_line" style="height:14px">&nbsp;&nbsp;&lt;artifactId&gt;GRecyclerView&lt;/artifactId&gt;</div><div class="ace_line" style="height:14px">&nbsp;&nbsp;&lt;version&gt;1.0&lt;/version&gt;</div><div class="ace_line" style="height:14px">&nbsp;&nbsp;&lt;type&gt;pom&lt;/type&gt;</div><div class="ace_line" style="height:14px">&lt;/dependency&gt;`</div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_markup ace_heading ace_3">###</span>if&nbsp;you&nbsp;want&nbsp;use&nbsp;custom&nbsp;header&nbsp;or&nbsp;footer</div><div class="ace_line" style="height:14px"><span class="ace_markup ace_heading ace_5">#####</span>you&nbsp;need&nbsp;custom&nbsp;class&nbsp;extends&nbsp;BaseRefreshHeader&nbsp;or&nbsp;BaseRefreshFooter&lt;br/&gt;&lt;br/&gt;</div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;class&nbsp;RefreshHeader&nbsp;extends&nbsp;BaseRefreshHeader&nbsp;{</span></div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;TextView&nbsp;mTv;</span></div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;RefreshHeader(Context&nbsp;context)&nbsp;{</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;super(context);</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;initView();</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;}</span></div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;private&nbsp;void&nbsp;initView()&nbsp;{</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;mTv&nbsp;=&nbsp;(TextView)&nbsp;findViewById(R.id.tv);</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;}</span></div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;@Override</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;View&nbsp;getContainerView(LayoutInflater&nbsp;inflater)&nbsp;{</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;inflater.inflate(R.layout.header,&nbsp;new&nbsp;FrameLayout(getContext()));</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;}</span></div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;@Override</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;void&nbsp;setState(int&nbsp;state)&nbsp;{</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;switch&nbsp;(state)&nbsp;{</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;case&nbsp;IRefreshHeader.STATE_NORMAL:</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;mTv.setText("<span class="ace_cjk" style="width:13.21875px">下</span><span class="ace_cjk" style="width:13.21875px">拉</span><span class="ace_cjk" style="width:13.21875px">刷</span><span class="ace_cjk" style="width:13.21875px">新</span>");</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;break;</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;case&nbsp;IRefreshHeader.STATE_RELEASE_TO_REFRESH:</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;mTv.setText("<span class="ace_cjk" style="width:13.21875px">释</span><span class="ace_cjk" style="width:13.21875px">放</span><span class="ace_cjk" style="width:13.21875px">刷</span><span class="ace_cjk" style="width:13.21875px">新</span>");</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;break;</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;case&nbsp;IRefreshHeader.STATE_REFRESHING:</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;mTv.setText("<span class="ace_cjk" style="width:13.21875px">正</span><span class="ace_cjk" style="width:13.21875px">在</span><span class="ace_cjk" style="width:13.21875px">刷</span><span class="ace_cjk" style="width:13.21875px">新</span>");</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;break;</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;case&nbsp;IRefreshHeader.STATE_DONE:</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;mTv.setText("<span class="ace_cjk" style="width:13.21875px">刷</span><span class="ace_cjk" style="width:13.21875px">新</span><span class="ace_cjk" style="width:13.21875px">完</span><span class="ace_cjk" style="width:13.21875px">成</span>");</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;break;</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;}</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;}</span></div><div class="ace_line" style="height:14px"></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;@Override</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;public&nbsp;View&nbsp;getRootView()&nbsp;{</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;this;</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;}</span></div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;}</span></div><div class="ace_line" style="height:14px">&nbsp;&nbsp;&nbsp;&nbsp;</div><div class="ace_line" style="height:14px"><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;class&nbsp;MainActivity&nbsp;extends&nbsp;Activity{</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;mGRecyclerView.setRefreshHeader(new&nbsp;RefreshHeader());</span></div><div class="ace_line" style="height:14px"><span class="ace_indent-guide">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="ace_support ace_function">&nbsp;&nbsp;&nbsp;&nbsp;mGRecyclerView.setRefreshFooter(...);</span></div></div><div class="ace_layer ace_marker-layer"></div><div class="ace_layer ace_cursor-layer"><div class="ace_cursor" style="left: 97px; top: 252px; width: 6.60938px; height: 14px;"></div></div></div></div><div style="height: auto; width: auto; top: -100px; left: -100px; visibility: hidden; position: fixed; overflow: visible; white-space: nowrap;">X</div><div class="ace_sb" style="width: 22px; height: 935px;"><div style="height: 2282px;"></div></div><div class="ace_gutter_tooltip" style="max-width: 500px; display: none;"></div></div>
        </div>
        <div class="mahua-right" id="mahua-result" style="width: 50%; margin-left: 50%;"> <iframe frameborder="0" marginheight="0" width="100%" src="./README_files/proxy.html" style="height: 935px;"></iframe></div>
    </div>
    <script type="text/javascript" async="" src="./README_files/h.js"></script><script type="text/javascript" src="./README_files/ace.js"></script>
    <script type="text/javascript" src="./README_files/keybinding-vim.js"></script>
    <script type="text/javascript" src="./README_files/all.js"></script>
    <script type="text/javascript">
        (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'hm.baidu.com/h.js?f628d86243daf05c564aa17f55e27b02'; 
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s); 
        })();
    </script>


</body></html>