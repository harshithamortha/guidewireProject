const projects = [
  {
    type: "project",
    title: "Simulated User Request Flow",
    description: "Ever wonder how a quote request becomes an insurance policy? This mini-app lets you follow a user's request as it zips through backend APIs, just like in a real insurance platform — minus the meetings.",
    badges: ["Spring Boot", "REST API", "Guidewire (simulated)", "Java 17"],
    detailsUrl: "policycenter-rest-api-integration.html"
  },
  {
    type: "project",
    title: "Smart Input Cleaner",
    description: "This tool sanitizes messy form inputs and enforces clean, backend-ready JSON structures. Ideal for preventing garbage-in-garbage-out scenarios in enterprise systems.",
    badges: ["Java", "Validation", "Spring Boot"],
    detailsUrl: "xml-data-processing.html"
  },
  {
    type: "project",
    title: "Secure System Messenger",
    description: "Enterprise systems need to talk too. This experiment simulates SOAP-based messaging between platforms — backend diplomacy, no endless email threads.",
    badges: ["Spring Boot", "SOAP", "Integration", "Java"],
    detailsUrl: "enterprise-soap-web-service-integration.html"
  }
];

function createProjectCard(item) {
  const card = document.createElement('div');
  card.className = 'project-card';

  const title = document.createElement('h2');
  title.className = 'project-title';
  title.textContent = item.title;
  card.appendChild(title);

  const desc = document.createElement('p');
  desc.className = 'project-description';
  desc.textContent = item.description;
  card.appendChild(desc);


  const badges = document.createElement('div');
  badges.className = 'tech-stack-badges';
  item.badges.forEach(b =>
    badges.innerHTML += `<span>${b}</span>`
  );
  card.appendChild(badges);


  if(item.type === "project") {
    const details = document.createElement('a');
    details.className = 'details-link';
    details.textContent = "See How it Works";
    details.href = item.detailsUrl;
    card.appendChild(details);
  }
  if(item.type === "game") {
    card.innerHTML += item.gameHtml;
    setTimeout(()=>item.setup(card), 1);  // Delay to let DOM update
  }

  return card;
}


function renderProjects() {
  const container = document.getElementById('projects');
  container.innerHTML = '';
  projects.forEach(proj => container.appendChild(createProjectCard(proj)));
}
document.addEventListener('DOMContentLoaded', renderProjects);
