<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="e" tagdir="/WEB-INF/tags" %>    
<e:header />
    
<section class="opinioes well span3">
    <h1>Opiniões</h1>
    <article class="opiniao" ng-repeat="op in opinioes | limitTo: 5">
        <h3>{{ op.nome }}</h3>
        <p>{{ op.descricao }}</p>
        <aside>Data: {{ op.data }}</aside>
        
    </article>
</section>
<section class="servicos well span3">
    <h1>Newsletter</h1>
    <article ng-repeat="noticia in noticias | paginacao:tamanho*pagina | limitTo: tamanho">
        <h5>{{ noticia.titulo }}</h5>
        <p>{{ noticia.conteudo }}</p>
    </article>
    <p><a href="#noticias" class="btn">Ver Mais</a></p>

    <button ng-click="pagina = pagina - 1" ng-disabled="pagina == 0" class="btn"><</button>
    <button ng-click="pagina = pagina + 1" ng-disabled='' class="btn pull-right">></button>
    <label for="noticias"><input type="checkbox" name="noticias" id="noticias"/>Você deseja receber Notícias no seu email?</label>
</section>
<section class="publicidade well span3">
    <h1>Publicidade</h1>
    <a href="#/{{ promocao.src }}" ng-repeat="promocao in promocoes | limitTo: 3">
        <article class="promocao">
            <h5>{{ promocao.titulo }}</h5>
            <img src="images/88bed3eb.doctor-02.jpg" alt="Promocao" />
            <p>{{ promocao.sobre }}</p>
        </article>
    </a>
</section>

<e:footer />