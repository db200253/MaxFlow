package Main;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class TestMaxFlow {

	public static void main(String[] args) {
	  
	  System.setProperty("org.graphstream.ui", "swing");
	  
		/*Graph g = new SingleGraph("test");
		g.addNode("s");
		g.addNode("1");
		g.addNode("2");
		g.addNode("t");*/
		
		Graph g2 = new SingleGraph("test2");
		g2.addNode("l");
    g2.addNode("n");
    g2.addNode("g");
    g2.addNode("o");
    g2.addNode("p");
    g2.addNode("m");
		
		//g.setAttribute("ui.stylesheet", "url('src/main/style/style.css')");
		g2.setAttribute("ui.stylesheet", "url('src/main/style/style.css')");
		
		/*for(Node node : g) {
      
      node.setAttribute("ui.label", node.getId());
    }*/
		
		for(Node node : g2) {
      
      node.setAttribute("ui.label", node.getId());
    }
		
		/*g.addEdge("e1", "s", "1", true).setAttribute("cap", 10);
		g.addEdge("e2", "s", "2", true).setAttribute("cap", 7);
		g.addEdge("e3", "1", "2", true).setAttribute("cap", 5);
		g.addEdge("e4", "1", "t", true).setAttribute("cap", 7);
		g.addEdge("e5", "2", "t", true).setAttribute("cap", 10);*/
		//g.display();
		
		g2.addEdge("e1", "l", "n", true).setAttribute("cap", 30);
		g2.addEdge("e2", "l", "g", true).setAttribute("cap", 25);
		g2.addEdge("e3", "n", "g", true).setAttribute("cap", 10);
		g2.addEdge("e4", "n", "o", true).setAttribute("cap", 15);
		g2.addEdge("e5", "g", "p", true).setAttribute("cap", 25);
		g2.addEdge("e7", "p", "o", true).setAttribute("cap", 5);
		g2.addEdge("e8", "g", "o", true).setAttribute("cap", 10);
		g2.addEdge("e9", "o", "m", true).setAttribute("cap", 35);
		g2.addEdge("e10", "p", "m", true).setAttribute("cap", 15);
		g2.display();
		
		/*MaxFlow mf = new MaxFlow();
		mf.setCapacityAttribute("cap");
		mf.init(g);
		mf.setSource(g.getNode("s"));
		mf.setSink(g.getNode("t"));
		mf.compute();*/
		
		MaxFlow mf = new MaxFlow();
    mf.setCapacityAttribute("cap");
    mf.init(g2);
    mf.setSource(g2.getNode("l"));
    mf.setSink(g2.getNode("m"));
    mf.compute();
		
		/*System.out.println(mf.getFlow());
		for (int i = 0; i < g.getEdgeCount(); ++i) {
		  Edge e = g.getEdge(i);
			double flow = mf.getFlow(e);
			double cap = mf.getCapacity(e);
			if (flow > 0) e.setAttribute("ui.label", "" + flow);
			if (cap == flow) e.setAttribute("ui.style", "fill-color: red;");
		}*/
    
    System.out.println(mf.getFlow());
    for (int i = 0; i < g2.getEdgeCount(); ++i) {
      Edge e = g2.getEdge(i);
      double flow = mf.getFlow(e);
      double cap = mf.getCapacity(e);
      if (flow > 0) e.setAttribute("ui.label", "" + flow);
      if (cap == flow) e.setAttribute("ui.style", "fill-color: red;");
    }
	}

}
