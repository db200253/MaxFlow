package Main;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

public class Autoroute {
  
  /**
   * Creation d'une variable graphe statique car variable de classe
   */
  static Graph graph = new MultiGraph("Réseau");

  public static void main(String[] args) {
    
    System.setProperty("org.graphstream.ui", "swing");
    
    /**
     * Construction du graphe via read de GS avec gestion d'erreur
     */
    try {
      
      graph.read("src/main/ressources/reseau.dgs");
    } catch(Exception e) {
      
      e.printStackTrace();
      System.exit(1);
    }
    
    /**
     * Feuille de style, affichage des noms et affichage du graphe
     */
    graph.setAttribute("ui.stylesheet", "url('src/main/style/style.css')");
    
    for(Node node : graph) {
      
      node.setAttribute("ui.label", node.getId());
    }
    
    graph.display(false);
    
    MaxFlow mf = new MaxFlow();
    mf.setCapacityAttribute("cap");
    mf.init(graph);
    mf.setSource(graph.getNode("A"));
    mf.setSink(graph.getNode("I"));
    mf.compute();
    
    System.out.println(mf.getFlow());
    for (int i = 0; i < graph.getEdgeCount(); ++i) {
      Edge e = graph.getEdge(i);
      double flow = mf.getFlow(e);
      double cap = mf.getCapacity(e);
      if (flow > 0) e.setAttribute("ui.label", "" + flow);
      if (cap == flow) e.setAttribute("ui.style", "fill-color: red;");
    }
  }
}