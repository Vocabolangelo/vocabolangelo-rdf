<section class="spotlight style1 orient-right content-align-left image-position-center onscroll-image-fade-in" id="first">
    <div class="content">
        {% assign query = 'SELECT (count(distinct ?word) as ?wordCount)
            WHERE {
                ?word rdf:type skos:Concept.
            }'
        %}
        {% assign resultset = page.rdf | sparql_query: query %}
        <h1> {{ resultset[0].wordCount }} </h1>
        <p>Sono le parole all'interno del Vocabolangelo. Puntiamo a raggiungere le 1000 parole.</p>
        <ul class="actions stacked">
            <li><a href="https://github.com/Vocabolangelo/" class="button"> Collabora </a></li>
        </ul>
    </div>
    <div class="image">
        <img src="images/math.jpg" alt="Matematica" />
    </div>
</section>
