---
rdf_prefix_path: "_data/prefixes.sparql"
layout: rdf_layout
title: {{gameLabel | flatify }}
---

{% assign definitionSet = page.rdf | rdf_property: 'skos:definition', nil, true %}

{% if definitionSet %}
<section>
    <header>
        <h3>Definizione</h3>
    </header>
    <div class="content">
        <ul>
        {% for definition in definitionSet %}
            <li>{{ definition }}</li>
        {% endfor %}
        </ul>
    </div>
</section>
{% endif %}
