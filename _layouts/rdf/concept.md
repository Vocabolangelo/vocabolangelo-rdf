---
rdf_prefix_path: "_data/prefixes.sparql"
layout: rdf_layout
---
{% assign prefLabel = page.rdf | rdf_property: 'skos:prefLabel' %}
{% assign definitionSet = page.rdf | rdf_property: 'skos:definition', nil, true %}
{% if definitionSet %}
<section>
    <header>
        <h3>Definizione</h3>
    </header>
    <div class="content">
        <ol>
        {% for definition in definitionSet %}
            <li>{{ definition }}</li>
        {% endfor %}
        </ol>
    </div>
</section>
{% endif %}
{% assign exampleSet = page.rdf | rdf_property: 'skos:example', nil, true %}
{% if exampleSet %}
<section>
    <header>
        <h3>Esempio</h3>
    </header>
    <div class="content">
        {% for example in exampleSet %}
            <blockquote>{{ example }}</blockquote>
        {% endfor %}
    </div>
</section>
{% endif %}
{% assign authors = page.rdf | rdf_property: 'dct:creator', nil, true %}
{% if authors %}
<section>
    <header>
        <h3>Autore</h3>
    </header>
    <div class="content">
        <ul>
        {% for c in authors %}
            <li>
                <a href="{{ c.page_url }}">
                    {{ c | rdf_property: 'foaf:lastName' }} {{ c | rdf_property: 'foaf:firstName' }}
                </a>
            </li>
        {% endfor %}
        </ul>
    </div>
</section>
{% endif %}
{% assign images = page.rdf | rdf_property: 'schema:image', nil, true %}
{% if images %}
<section>
    <header>
        <h3>Immagini</h3>
    </header>
    <div class="content">
        <ul>
        {% for i in images %}
            <span class="image left">
                <img src="{{ i }}" alt="Profile Image">
            </span>
        {% endfor %}
        </ul>
    </div>
</section>
{% endif %}
{% assign correlated = page.rdf | rdf_property: 'skos:related', nil, true %}
{% if correlated %}
<section>
    <header>
        <h3>Parole correlate</h3>
    </header>
    <div class="content">
        <ul>
        {% for w in correlated %}
            <li>
                <a href="{{ w.page_url }}" style="display:inline">
                    {{ w | rdf_property: 'skos:prefLabel' }}
                </a>
            </li>
        {% endfor %}
        </ul>
    </div>
</section>
{% endif %}
{% assign created = page.rdf | rdf_property: 'dct:created', nil, true %}
{% if created %}
<section>
    <header>
        <h3>Data di nascita</h3>
    </header>
    <div class="content">
        {{ created[0] | date: "%d/%m/%Y" }}
    </div>
</section>
{% endif %}
