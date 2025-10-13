import {CORE_CONCEPTS} from "./data";
import {EXAMPLES} from "./data";
import CoreConcepts from "./components/CoreConcepts";
import Header from "./components/Header/Header";
import {TabButton} from "./components/TabButton";
import {useState} from "react";


function App() {
    let [data, setData] = useState();

    const examples = EXAMPLES;
    function handleSelect(selectedButton){

        return(setData(selectedButton));
    }

    let tabContent = <p>Please select topic</p>;

    if (data) {
        tabContent = (
            <div id="tab-content">
                <h3>{EXAMPLES[data].title}</h3>
                <p>{EXAMPLES[data].description}</p>
                <pre>
                  <code>
                      {EXAMPLES[data].code}
                  </code>
              </pre>
            </div>
        )
    }

    return (
    <div>
      <Header />
      <main>
          <section id="core-concepts">
              <h2>Core Concepts</h2>
              <ul>
                  {CORE_CONCEPTS.map((item,key) =>
                      <li key={key}>
                          <CoreConcepts image={item.image}
                                        title={item.title}
                                        description={item.description} />
                      </li>)
                  }
              </ul>
          </section>
          <section id="examples">
              <h2>Examples</h2>
              <menu>
                  <TabButton isSelected={data === 'components'} onSelect={() => handleSelect('components')}>Components</TabButton>
                  <TabButton isSelected={data === 'jsx'} onSelect={() => handleSelect('jsx')}>JSX</TabButton>
                  <TabButton isSelected={data === 'props'} onSelect={() => handleSelect('props')}>Props</TabButton>
                  <TabButton isSelected={data === 'state'} onSelect={() => handleSelect('state')}>State</TabButton>
              </menu>
          </section>
          {tabContent}
      </main>
    </div>
  );
}

export default App;
