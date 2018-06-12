export interface Session {
	name: string;
	id: number;
}

export interface Ticket {
	access_group_name: string;
	access_group_id: number;
	total_uses: number;
	sessions: Session[];
	event_id: number;
	structure_decode: boolean;
	name: string;
	modified: Date;
	id: number;
	basic_product_id: number;
}


