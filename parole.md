---
layout: default
title: Parolangelo
subtitle: Tutte le parole del vocabolangelo sono elencate in questa pagina.
---

{% for letter in site.letters %}
{% assign query =
    'SELECT ?word ?label
    WHERE {
        ?word rdf:type skos:Concept.
        ?word skos:prefLabel ?label.
        FILTER(strStarts(?label, "' | append: letter | append: '")).
    }
    ORDER BY ?label'
%}
{% assign resultset = page.rdf | sparql_query: query %}
{% assign resultsetSize = resultset | size %}
{% if resultsetSize != 0 %}
<section>
    <header> <h2> {{ letter }} </h2> </header>
    <div class="content">
        <ul>
        {% for result in resultset %}
            <li>
                <a href="{{ result.word.page_url }}">
                    {{ result.label }}
                </a>
            </li>
        {% endfor %}
        </ul>
    </div>
</section>
{% endif %}
{% endfor %}
